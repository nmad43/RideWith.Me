package com.g5.ridewithme;

import com.g5.ridewithme.EMF;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.api.users.User;
import com.google.appengine.datanucleus.query.JPACursorHelper;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Api(name = "customerendpoint", namespace = @ApiNamespace(ownerDomain = "g5.com", ownerName = "g5.com", packagePath = "ridewithme"))
public class CustomerEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listCustomer")
	public CollectionResponse<Customer> listCustomer(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

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

		return CollectionResponse.<Customer> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}
	
	public static boolean isACustomer(User user)
	{
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Customer item = mgr.find(Customer.class, user.getUserId());
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
			if (!item.getId().equals(id)) {
				contains = false;
			}
		} finally {
			mgr.close();
		}
		return contains;
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getCustomer")
	public Customer getCustomer(@Named("id") String id, User user) throws OAuthRequestException{
		EntityManager mgr = getEntityManager();
		Customer customer = null;
		if(user == null)
			throw new OAuthRequestException("Not a user");
		
		if(isACustomer(user))
		{
			try {
				customer = mgr.find(Customer.class, id);
			} finally {
				mgr.close();
			}
		} else {
			// not a user of the service
		}
		return customer;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param customer the entity to be inserted.
	 * @return The inserted entity.
	 * @throws OAuthRequestException 
	 */
	@ApiMethod(name = "insertCustomer")
	public Customer insertCustomer(Customer customer, User user) throws OAuthRequestException {
		EntityManager mgr = getEntityManager();
		if(user == null)
			throw new OAuthRequestException("Must be signed in");
		Customer cust = new Customer(user.getUserId(), customer.getFirstName(), customer.getLastName(), user.getEmail(), customer.getLocation(), customer.getCar());
		
		try {
			if (containsCustomer(cust)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(cust);
		} finally {
			mgr.close();
		}
		return cust;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param customer the entity to be updated.
	 * @return The updated entity.
	 * @throws OAuthRequestException 
	 */
	@ApiMethod(name = "updateCustomer", path = "{id}")
	public Customer updateCustomer(@Named("id") String id, User user) throws OAuthRequestException {
		EntityManager mgr = getEntityManager();
		Customer customer;
		if(user == null)
		{
			throw new OAuthRequestException("Not logged in");
		}
		if(verifyCustomer(id, user.getUserId()))
		{
			try {
				if (!isACustomer(user)) {
					throw new EntityNotFoundException("Object does not exist");
				}
				customer = getCustomer(id, user);
				mgr.persist(customer);
			} finally {
				mgr.close();
			}
		} else {
			throw new OAuthRequestException("No access to update user");
		}
		return customer;
	}


	private boolean containsCustomer(Customer customer) {
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

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

}
