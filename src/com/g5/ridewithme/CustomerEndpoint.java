package com.g5.ridewithme;

import com.g5.ridewithme.EMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
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

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getCustomer")
	public Customer getCustomer(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		Customer customer = null;
		try {
			customer = mgr.find(Customer.class, id);
		} finally {
			mgr.close();
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
	 */
	@ApiMethod(name = "insertCustomer")
	public Customer insertCustomer(Customer customer) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsCustomer(customer)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(customer);
		} finally {
			mgr.close();
		}
		return customer;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param customer the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateCustomer")
	public Customer updateCustomer(Customer customer) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsCustomer(customer)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(customer);
		} finally {
			mgr.close();
		}
		return customer;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeCustomer")
	public void removeCustomer(@Named("id") Long id) {
		EntityManager mgr = getEntityManager();
		try {
			Customer customer = mgr.find(Customer.class, id);
			mgr.remove(customer);
		} finally {
			mgr.close();
		}
	}

	private boolean containsCustomer(Customer customer) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Customer item = mgr.find(Customer.class, customer.getKey());
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
