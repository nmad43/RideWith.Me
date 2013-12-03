package com.g5.ridewithme;

import java.util.ArrayList;
import java.util.Queue;

public class NotificationBuilder {
	private boolean processing = false;
	private Queue<ArrayList<Object>> requests;
	
	public boolean makeRequest(ArrayList<Object> request){
		requests.add(request);
		return processing;
	}//end makeRequest
	
	public Notification build(){
		ArrayList<Object> request = requests.remove();
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
		return new Notification(recipient, body);
	}//end build
	
	public boolean requestsInQueue(){
		return !requests.isEmpty();
	}//end requestsInQueue
	
	public void startProcessing(){
		processing = true;
	}//end startProcessing
	
	public void endProcessing(){
		processing = false;
	}//end endProcessing
}//end NotificationBuilder
