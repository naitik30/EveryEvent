package com.every.events.restdata;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URI;
 
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Meetup {

	String city = "";
	String topic = "";
	String state = "";
	String event_id="";
	String group_id = "";

	public String getEvent(String path_code,String key) throws Exception{
		String responseString = "";
		URI request=null;
		
		if (!topic.isEmpty() && event_id.isEmpty()){
			System.out.println("yes");
			request = new URIBuilder()			//We build the request URI
					.setScheme("http")
					.setHost("api.meetup.com")
					.setPath(path_code)
					//List of parameters :
					.setParameter("topic", topic)
					.setParameter("city", city)
					.setParameter("state", state)
					.setParameter("page", "10")
						//End of params
					.setParameter("key", key)
					.build();
		}
		else if(topic.isEmpty() && event_id.isEmpty()){
			System.out.println("empty");
			request = new URIBuilder()			//We build the request URI
					.setScheme("http")
					.setHost("api.meetup.com")
					.setPath(path_code)
//					//List of parameters :
//					.setParameter("topic", topic)
					.setParameter("city", city)
					.setParameter("state", state)
					.setParameter("country", "US")
					//End of params
					.setParameter("key", key)
					.build();
		}else if(!event_id.isEmpty()){
			System.out.println("empty");
			request = new URIBuilder()			//We build the request URI
					.setScheme("http")
					.setHost("api.meetup.com")
					.setPath(path_code)
					.setParameter("event_id", event_id)
					//End of params
					.setParameter("key", key)
					.build();
		}

 
		HttpGet get = new HttpGet(request);			//Assign the URI to the get request
		System.out.println("Get request : "+get.toString());
 
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = client.execute(get);
		responseString = EntityUtils.toString(response.getEntity());
 
		return responseString;
	}
 
	public String getGroup(String path_code,String key) throws Exception{
		String responseString = "";
		URI request;
		
		request = new URIBuilder()			//We build the request URI
					.setScheme("http")
					.setHost("api.meetup.com")
					.setPath(path_code)
					.setParameter("group_id", group_id)
					.setParameter("key", key)
					.build();

 
		HttpGet get = new HttpGet(request);			//Assign the URI to the get request
		System.out.println("Get request : "+get.toString());
 
		CloseableHttpClient client = HttpClients.createDefault();
		CloseableHttpResponse response = client.execute(get);
		responseString = EntityUtils.toString(response.getEntity());
//		System.out.println(responseString);
		return responseString;
	}
 
	public String getApiKey(String key_path){

		return "7452177e7c4a26367a6d28443c144458";																//Return the key value.
	}
}
