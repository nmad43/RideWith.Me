package com.g5.ridewithme;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.api.users.User;
import com.google.appengine.datanucleus.query.JPACursorHelper;

public class DatastoreFacade {
	
	public static boolean isACustomer(String id)
	{
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Customer item = mgr.find(Customer.class, id);
			if (item == null) {
				contains = false;
			}
		} finally {
			mgr.close();
		}
		return contains;
	}
	
	private static boolean containsCustomer(Customer customer) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Customer item = mgr.find(Customer.class, customer.getId());
			if (item == null) {
				contains = false;
			}
		} finally {
			mgr.close();
		}
		return contains;
	}
	
	public static boolean verifyCustomer(String id, String UserId)
	{
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Customer item = mgr.find(Customer.class, UserId);
			if (item == null || !item.getId().equals(id)) {
				contains = false;
			}
		} finally {
			mgr.close();
		}
		return contains;
	}
	
	public static void addCustomer(Customer customer)
	{
		EntityManager mgr = getEntityManager();
		try {
			if (containsCustomer(customer)) {
				throw new EntityExistsException("Customer already exists");
			}
			mgr.persist(customer);
		} finally {
			mgr.close();
		}
	}
	
	public static Customer fetchCustomer(String id)
	{
		EntityManager mgr = getEntityManager();
		Customer customer = null;
		try {
            customer = mgr.find(Customer.class, id);
		} finally {
            mgr.close();
		}
		return customer;
	}
	
	public static List<Customer> listCustomers(String cursorString, Integer limit)
	{
		EntityManager mgr = null;
		Cursor cursor = null;
		List<Customer> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr.createQuery("select from Customer as Customer");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<Customer>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Customer obj : execute)
				;
		} finally {
			mgr.close();
		}
		
		return execute;
	}
	
	public static Customer updateCustomer(Customer customer, String id)
	{
		EntityManager mgr = getEntityManager();
	
		try {
			if (!isACustomer(id)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			customer = fetchCustomer(id);
			mgr.persist(customer);
		} finally {
			mgr.close();
		}
		return customer;
	}
	
	public static void addCarpool(Carpool carpool)
	{
		EntityManager mgr = getEntityManager();
		try {
			if (containsCarpool(carpool)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(carpool);
		} finally {
			mgr.close();
		}
	}
	
	public static List<Carpool> listCarpools(String cursorString, Integer limit)
	{
		EntityManager mgr = null;
		Cursor cursor = null;
		List<Carpool> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr.createQuery("select from Carpool as Carpool");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<Carpool>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Carpool obj : execute)
				;
		} finally {
			mgr.close();
		}
		
		return execute;
	}
	
	public static Carpool fetchCarpool(String id)
	{
		EntityManager mgr = getEntityManager();
		Carpool carpool = null;
		try {
			carpool = mgr.find(Carpool.class, id);
		} finally {
			mgr.close();
		}
		return carpool;
	}
	
	public static Carpool updateCarpool(Carpool carpool)
	{
		EntityManager mgr = getEntityManager();
		try {
			if (!containsCarpool(carpool)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			
			mgr.persist(carpool);
		} finally {
			mgr.close();
		}
		return null;
	}
	
	public static void removeCarpool(Carpool carpool)
	{
		EntityManager mgr = getEntityManager();
		try {
			
			mgr.remove(carpool);
		} finally {
			mgr.close();
		}
		
	}
	
	public static boolean isRider(List<String> list, User user) throws OAuthRequestException{
		for(String rider:list) if(verifyCustomer(rider, user.getUserId())) return true;
		return false;
	}//end isRider
	
	private static boolean containsCarpool(Carpool carpool) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Carpool item = mgr.find(Carpool.class, carpool.getId());
			if (item == null) {
				contains = false;
			}//end if
		} finally {
			mgr.close();
		}
		return contains;
	}//end containsCarpool
	
	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}
}
