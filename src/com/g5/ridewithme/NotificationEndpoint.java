package com.g5.ridewithme;

import java.util.ArrayList;

import com.g5.ridewithme.EMF;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JPACursorHelper;


@Api(name = "notificationendpoint", namespace = @ApiNamespace(ownerDomain = "g5.com", ownerName = "g5.com", packagePath = "ridewithme"))
public class NotificationEndpoint {
	private NotificationBuilder builder;

	public void requestBuild(ArrayList<Object> request){
		builder.makeRequest(request);
	}
	
	public void getSendMethod(){
		
	}
	
	public void sendEmail(){
		
	}
}
