package com.every.events.restdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class EventBriteGetter {
	String city = "";
	String topic = "";
 
	//https://www.eventbriteapi.com/v3/events/search/?token=2S76CILPCTVND54FFE77&venue.city=san%20jose
	
	public String getEvent(String path_code,String key) throws Exception{
		String responseString = "";
 
		URI request = new URIBuilder()			//We build the request URI
			.setScheme("https")
			.setHost("www.eventbriteapi.com")
			.setPath(path_code)
			//List of parameters :
			.setParameter("venue.city", "fremont")
			//End of params
			.setParameter("token", "2S76CILPCTVND54FFE77")
			.build();
		
	
		HttpGet get = new HttpGet(request);			//Assign the URI to the get request
		System.out.println("Get request : "+get.toString());
 
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = client.execute(get);
		responseString = EntityUtils.toString(response.getEntity());
 
		return responseString;
	}
 
	public String getVenue(String path_code, String key) throws Exception{
		String responseString = "";
		 
		URI request = new URIBuilder()			//We build the request URI
			.setScheme("https")
			.setHost("www.eventbriteapi.com")
			.setPath(path_code)
			.setParameter("token", "2S76CILPCTVND54FFE77")
			.build();
		
	
		HttpGet get = new HttpGet(request);			//Assign the URI to the get request
		System.out.println("Get request : "+get.toString());
 
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = client.execute(get);
		responseString = EntityUtils.toString(response.getEntity());
 
		return responseString;
	}
	
	public String getApiKey(String key_path){
		String key = "2S76CILPCTVND54FFE77";
		return key;	  //Return the key value.
	}

}
