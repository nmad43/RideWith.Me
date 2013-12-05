package com.g5.ridewithme;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

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
		this.carpools = new ArrayList<Key>();
	}
	
	public Customer(String id, String firstName, String lastName, String email, String location, String car) {
		this.id = KeyFactory.stringToKey(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.location = location;
		this.car = car;
		this.carpools = new ArrayList<Key>();
		
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
	
	public List<Key> getCarpools()
	{
		return carpools;
	}
	
	public void addCarpool(Key carpoolId) {
		carpools.add(carpoolId);
	}
	
	public void removeCarpool(Key carpoolId) {
		carpools.remove(id);
	}
}
