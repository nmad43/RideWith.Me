package com.g5.ridewithme;

import java.util.ArrayList;

public class Summary extends Request {
	private String departure;
	private ArrayList<String> riders;
	
	public Summary(String recipient, String date, String destination, String departure, ArrayList<String> riders){
		setType("summary");
		setRecipient(recipient);
		setDate(date);
		setDestination(destination);
		setDeparture(departure);
		setRiders(riders);
	}//end Summary Constructor
	
	public String getDeparture(){
		return departure;
	}//end getDeparture
	
	public void setDeparture(String departure){
		this.departure = departure;
	}//end setDeparture
	
	public ArrayList<String> getRiders(){
		return riders;
	}//end getRiders
	
	public void setRiders(ArrayList<String> riders){
		this.riders = riders;
	}//end setRiders
}
