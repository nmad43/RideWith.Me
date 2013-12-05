package com.g5.ridewithme;

public class Update extends Request{
	String departure;
	String sender;
	
	public Update(String type, String recipient, String sender, String date, String destination, String departure){
		setType(type);
		setRecipient(recipient);
		setSender(sender);
		setDate(date);
		setDestination(destination);
		setDeparture(departure);
	}//end Update constructor
	
	public String getSender(){
		return sender;
	}//end getSender
	
	public void setSender(String sender){
		this.sender = sender;
	}//end setSender
	
	public String getDeparture(){
		return departure;
	}//end getDeparture
	
	public void setDeparture(String departure){
		this.departure = departure;
	}//end setDeparture
}
