package com.g5.ridewithme;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String location;
	private String car;
	
	public User() {
		
	}
	
	public String getId() {
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
