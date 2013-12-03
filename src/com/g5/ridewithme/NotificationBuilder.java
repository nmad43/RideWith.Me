package com.g5.ridewithme;

import java.util.ArrayList;
import java.util.Queue;

public class NotificationBuilder {
	private boolean processing = false;
	private Queue<ArrayList<Object>> requests;
	
	public void makeRequest(ArrayList<Object> request){
		requests.add(request);
		if(!isProcessing()) handleRequests();
	}//end makeRequest
	
	public void handleRequests(){
		processing = true;
		while(!requests.isEmpty()){
			build(requests.remove());
		}//end while
		processing = false;
	}//end handleRequests
	
	public void build(ArrayList<Object> request){
		String type = (String)request.get(0);
		String recipient = (String)request.get(1);
		String body = "";
		switch(type){
			case "summary":
				body += "Ride With Me Carpool Summary:\n";
				body += "\tDriver: " + recipient + "\n";
				body += "\tDate: " + (String)request.get(2) + "\n";
				body += "\tDeparture Time: " + (String)request.get(3) + "\n";
				body += "\tDestination: " + (String)request.get(4) + "\n";
				ArrayList<String> riders = (ArrayList<String>)request.get(5);
				body += "\tRiders:\n";
				for(String rider:riders){
					body += "\t" + rider + "\n";
				}//end for
				body += "Thank you," + recipient +  ",for using Ride With Me.\n";
				body += "To view the route for this carpool, log in to RideWith.Me and visit the My Carpools page.";
			case "invitation":
				body += "Hey, " + recipient + "!\n";
				body += (String)request.get(2) + " has invited you to a carpool through Ride With Me.\n";
				body += "\tDestination: " + (String)request.get(3) + "\n";
				body += "\tDate: " + (String)request.get(4) + "\n";
				body += "\tDeparture Time: " + (String)request.get(5) + "\n";
				body += "To accept/decline your invitation, log in to RideWith.Me and visit the My Carpools page.";
			case "update":
				body += "Hello, " + recipient + "!\n";
				body += (String)request.get(2) + " has made changes to one of your carpools.\n";
				body += "\tDestination: " + (String)request.get(3) + "\n";
				body += "\tDate: " + (String)request.get(4) + "\n";
				body += "\tDeparture Time: " + (String)request.get(5) + "\n";
				body += "For more details, log in to RideWith.Me and visit the My Carpools page.";
			case "cancellation":
				body += "Hello, " + recipient + "!\n";
				body += (String)request.get(2) + " has cancelled one of your carpools.\n";
				body += "\tDestination: " + (String)request.get(3) + "\n";
				body += "\tDate: " + (String)request.get(4) + "\n";
				body += "\tDeparture Time: " + (String)request.get(5) + "\n";
				body += "For more details, log in to RideWith.Me and visit the My Carpools page.";
		}//end switch
		sendEmail(new Notification(recipient, body));
	}//end build
	
	public void sendEmail(Notification message){
		
	}
	
	public boolean isProcessing(){
		return processing;
	}//end isProcessing
}//end NotificationBuilder
