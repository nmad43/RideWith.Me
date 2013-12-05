package com.g5.ridewithme;

public class Request {
	private String type;
	private String recipient;
	private String date;
	private String destination;
	
	public String getType(){
		return type;
	}//end getType
	
	public void setType(String type){
		this.type = type;
	}//end setType
	
	public String getRecipient(){
		return recipient;
	}//end getRecipient
	
	public void setRecipient(String recipient){
		this.recipient = recipient;
	}//end setRecipient
	
	public String getDate(){
		return date;
	}//end getDate
	
	public void setDate(String date){
		this.date = date;
	}//end setDate
	
	public String getDestination(){
		return destination;
	}//end getDestination
	
	public void setDestination(String destination){
		this.destination = destination;
	}//end setDestination
}
