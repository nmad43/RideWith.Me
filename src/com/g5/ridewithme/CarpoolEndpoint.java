package com.g5.ridewithme;

import com.g5.ridewithme.EMF;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.datanucleus.query.JPACursorHelper;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.api.users.User;






import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Api(name = "carpoolendpoint", namespace = @ApiNamespace(ownerDomain = "g5.com", ownerName = "g5.com", packagePath = "ridewithme"))
public class CarpoolEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listCarpool")
	public CollectionResponse<Carpool> listCarpool(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		List<Carpool> execute = DatastoreFacade.listCarpools(cursorString, limit);


		return CollectionResponse.<Carpool> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getCarpool")
	public Carpool getCarpool(@Named("id") String id, User user) throws OAuthRequestException{
		Carpool carpool = DatastoreFacade.fetchCarpool(id);
		if(!((DatastoreFacade.verifyCustomer(carpool.getDriver(), user.getUserId()) || DatastoreFacade.isRider(carpool.getRiders(), user)))){
			throw new OAuthRequestException("User does not have acces to this carpool.");
		}
		
		return carpool;
	}//end getCarpool
	


	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param carpool the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertCarpool")
	public Carpool insertCarpool(Carpool carpool, User user) throws OAuthRequestException{
		DatastoreFacade.addCarpool(carpool);
		return carpool;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param carpool the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateCarpool")
	public Carpool updateCarpool(Carpool carpool, User user) throws OAuthRequestException{
		
		if(!((DatastoreFacade.verifyCustomer(carpool.getDriver(), user.getUserId()) || DatastoreFacade.isRider(carpool.getRiders(), user)))){
			throw new OAuthRequestException("User does not have acces to this carpool.");
		}
		
		DatastoreFacade.updateCarpool(carpool);
		
		return carpool;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeCarpool")
	public void removeCarpool(@Named("id") String id, User user) throws OAuthRequestException{
		Carpool carpool = DatastoreFacade.fetchCarpool(id);
		if(!((DatastoreFacade.verifyCustomer(carpool.getDriver(), user.getUserId()) || DatastoreFacade.isRider(carpool.getRiders(), user)))){
			throw new OAuthRequestException("User does not have acces to this carpool.");
		}//end if
		DatastoreFacade.removeCarpool(carpool);
	}



	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

}
