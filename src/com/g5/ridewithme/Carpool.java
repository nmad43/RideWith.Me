package com.g5.ridewithme;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.google.appengine.api.datastore.Key;

@Entity
public class Carpool {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	
	@OneToOne
	private Customer driver;
	
	
	private List<Customer> riders;
	private String destination;
	private String lastRoute;
	
	public Carpool() {
		
	}
	
	public Key getKey() {
		return key;
	}
	
	public Customer getDriver() {
		return driver;
	}
	
	public List<Customer> getRiders() {
		return riders;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public String getLastRoute() {
		return lastRoute;
	}
	
	public void addRider(Customer rider) {
		riders.add(rider);
	}
	
	public void setLastRoute(String route) {
		lastRoute = route;
	}

}
