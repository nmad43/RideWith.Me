package com.g5.ridewithme;

import java.util.ArrayList;
import java.util.Queue;

public class NotificationBuilder {
	private boolean processing = false;
	private Queue<Request> requests;
	
	public boolean makeRequest(Request request){
		requests.add(request);
		return processing;
	}//end makeRequest
	
	public Notification build(){
		Request request = requests.remove();
		String type = request.getType();
		String recipient = request.getRecipient();
		String date = request.getDate();
		String body = "";
		switch(type){
			case "summary":
				Summary summary = (Summary)request;
				body += "Ride With Me Carpool Summary:\n";
				body += "\tDriver: " + recipient + "\n";
				body += "\tDate: " + date + "\n";
				body += "\tDeparture Time: " + summary.getDeparture() + "\n";
				body += "\tDestination: " + summary.getDestination() + "\n";
				ArrayList<String> riders = summary.getRiders();
				body += "\tRiders:\n";
				for(String rider:riders){
					body += "\t" + rider + "\n";
				}//end for
				body += "Thank you," + recipient +  ",for using Ride With Me.\n";
				body += "To view the route for this carpool, log in to RideWith.Me and visit the My Carpools page.";
			case "invitation":
				Invitation invitation = (Invitation)request;
				body += "Hey, " + recipient + "!\n";
				body += invitation.getSender() + " has invited you to a carpool through Ride With Me.\n";
				body += "\tDestination: " + invitation.getDestination() + "\n";
				body += "\tDate: " + invitation.getDate() + "\n";
				body += "\tDeparture Time: " + invitation.getDeparture() + "\n";
				body += "To accept/decline your invitation, log in to RideWith.Me and visit the My Carpools page.";
			case "update":
				Update update = (Update)request;
				body += "Hello, " + recipient + "!\n";
				body += update.getSender() + " has made changes to one of your carpools.\n";
				body += "\tDestination: " + update.getDestination() + "\n";
				body += "\tDate: " + update.getDate() + "\n";
				body += "\tDeparture Time: " + update.getDeparture() + "\n";
				body += "For more details, log in to RideWith.Me and visit the My Carpools page.";
			case "cancellation":
				Update cancel = (Update) request;
				body += "Hello, " + recipient + "!\n";
				body += cancel.getSender() + " has cancelled one of your carpools.\n";
				body += "\tDestination: " + cancel.getDestination() + "\n";
				body += "\tDate: " + cancel.getDate() + "\n";
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
