package com.g5.ridewithme;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.google.appengine.api.datastore.Key;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	private String firstName;
	private String lastName;
	private String email;
	private String location;
	private String car;
	
	public Customer() {
		
	}
	
	public Key getKey() {
		return key;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getCar() {
		return car;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setCar(String car) {
		this.car = car;
	}
}
