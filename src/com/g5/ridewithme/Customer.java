package com.g5.ridewithme;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.google.appengine.api.datastore.Key;

@Entity
public class Customer {
	
	@Id
	private Key id;
	private String firstName;
	private String lastName;
	private String email;
	private String location;
	private String car;
	private List<Key> carpools;
	
	public Customer() {
		
	}
	
	public Key getId() {
		return id;
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
