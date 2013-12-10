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

		List<Customer> execute = DatastoreFacade.listCustomers(cursorString, limit);

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
	public Customer getCustomer(@Named("id") String id, User user) throws OAuthRequestException{
		Customer customer = null;
		if(user == null)
			throw new OAuthRequestException("Not a user");
		
		if(DatastoreFacade.isACustomer(user.getUserId()))
		{
			customer = DatastoreFacade.fetchCustomer(id);
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
		
		if(user == null)
			throw new OAuthRequestException("Must be signed in");
		Customer cust = new Customer(user.getUserId(), customer.getFirstName(), customer.getLastName(), user.getEmail(), customer.getLocation(), customer.getCar());
		
		DatastoreFacade.addCustomer(cust);
		
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
	public Customer updateCustomer(@Named("id") String id, Customer customer, User user) throws OAuthRequestException {
		if(user == null)
		{
			throw new OAuthRequestException("Not logged in");
		}
		if(DatastoreFacade.verifyCustomer(id, user.getUserId()))
		{
			DatastoreFacade.updateCustomer(customer, id);
		} else {
			throw new OAuthRequestException("No access to update user");
		}
		return customer;
	}



}
