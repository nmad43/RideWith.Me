package com.g5.ridewithme;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carpool {
	
	@Id
	private String id;
	private String driver;
	private List<String> riders;
	private String destination;
	private String lastRoute;
	
	public Carpool() {
		
	}
	
	public String getId() {
		return id;
	}
	
	public String getDriver() {
		return driver;
	}
	
	public List<String> getRiders() {
		return riders;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public String getLastRoute() {
		return lastRoute;
	}
	
	public void addRider(String rider) {
		riders.add(rider);
	}
	
	public void setLastRoute(String route) {
		lastRoute = route;
	}

}
