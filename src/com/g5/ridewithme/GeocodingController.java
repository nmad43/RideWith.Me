package com.g5.ridewithme;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.URLEncoder;

public class GeocodingController {
	
	private static final String geocodeURL = "https://maps.googleapis.com/maps/api/";
	
	public String requestRouteCalculate(String locations[]) {
		String routeParams = "directions/xml?";
		routeParams += "origin=" + URLEncoder.encode(locations[0]);
		routeParams += "&destination=" + URLEncoder.encode(locations[1]);
		if(locations.length > 2) {
			routeParams += "&waypoints=";
			for(int i = 2; i < locations.length - 1; i++) {
				routeParams += URLEncoder.encode(locations[i]) + "|";
			}
			routeParams += URLEncoder.encode(locations[locations.length - 1]);
		}
		try {
			URL url = new URL(geocodeURL + routeParams);
			// TODO: read result
		} catch (MalformedURLException e) {
			
		} catch (IOException e) {
			
		}
		return "";
	}
}
