package com.g5.ridewithme;

public class Notification {
	
	private String sender;
	private String recipient;
	private String body;
	
	public Notification(String recipient, String body){
		this.recipient = recipient;
		this.body = body;
	}//end Notification constructor
	
	public String getSender(){
		return sender;
	}//end getSender
	
	public String getRecipient(){
		return recipient;
	}//end getRecipient
	
	public String getBody(){
		return body;
	}//end getBody
}//end Notification
