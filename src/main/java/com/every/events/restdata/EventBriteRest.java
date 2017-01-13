package com.every.events.restdata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.json.JsonArray;
import javax.json.JsonObject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.every.events.model.EventGroup;
import com.every.events.model.Events;
import com.every.events.model.Venue;

public class EventBriteRest {

	public static ArrayList<Events> getEventsObj(String city, String topics) {
		EventBriteGetter ebg = new EventBriteGetter();
		String path_code = "/v3/events/search";
		String key=ebg.getApiKey();
		String events = "";
		ArrayList<Events> events_obj = new ArrayList<Events>();
		
		ebg.city = city;
		ebg.topic = topics;
		try {
			events = ebg.getEvent(path_code, key);
			events_obj = DecodeJSON(events);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return events_obj;
			
	}
	public static ArrayList<Events> getEventsObjByCity(String city) {
		EventBriteGetter ebg = new EventBriteGetter();
		String path_code = "/v3/events/search";
		String key=ebg.getApiKey();
		String events = "";
		ArrayList<Events> events_obj = new ArrayList<Events>();
		
		ebg.city = city;
		try {
			events = ebg.getEvent(path_code, key);
			events_obj = DecodeJSON(events);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return events_obj;
	}
	public static ArrayList<Events> getEventsObjByTopics(String topics) {
		EventBriteGetter ebg = new EventBriteGetter();
		String path_code = "/v3/events/search";
		String key=ebg.getApiKey();
		String events = "";
		ArrayList<Events> events_obj = new ArrayList<Events>();
		
		ebg.topic = topics;
		try {
			events = ebg.getEvent(path_code, key);
			events_obj = DecodeJSON(events);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return events_obj;
	}
	public static Events getEventsObjByID(String id) {
		EventBriteGetter ebg = new EventBriteGetter();
		String path_code="/v3/events/"+id+"/";
		JSONParser parser = new JSONParser();
		String key=ebg.getApiKey();
		String events = "";
		Events events_obj = new Events();
		
		try {
			events = ebg.getVenue(path_code, key);
			JSONObject event_obj = 	(JSONObject) parser.parse(events);
			events_obj = eventobjFromJson(event_obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return events_obj;
	}
	public static ArrayList<Events> DecodeJSON(String events) throws java.text.ParseException{
		
		ArrayList<Events> events_obj = new ArrayList<Events>();
		String key_path= "";
		JSONParser parser = new JSONParser();
		JSONObject obj;
		try {
			obj = (JSONObject) parser.parse(events);
			JSONArray results = (JSONArray) obj.get("events");
			Iterator i = results.iterator();
			int j= 0;
			while(i.hasNext() && j<15)
			{

				JSONObject eventbrite= (JSONObject) i.next();
				Events e  = new Events();
				e= eventobjFromJson(eventbrite);
				events_obj.add(e);
				j++;
			}
		} catch (ParseException ewe) {
			// TODO Auto-generated catch block
			ewe.printStackTrace();
		}
		

		return events_obj;
	}
	public static Events eventobjFromJson(JSONObject eventbrite) throws java.text.ParseException
	{
		EventBriteGetter ebg = new EventBriteGetter();
		Events e = new Events();
		String key_path= "";
		String key = ebg.getApiKey();
		JSONParser parser = new JSONParser();
		JSONObject obj;
		String organization = "";
		String venues = "";

		
		Date s = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(eventbrite.get("created").toString().replaceAll("Z$", "+0000"));
		e.setCreated(s);
		
		// description
		if (eventbrite.containsKey("description"))
		{
			JSONObject desc = (JSONObject)eventbrite.get("description");
			if(desc.get("html")!=null){
				e.setDescription(desc.get("html").toString());
			}else
			{
				e.setDescription("Not Given in API");
			}
		}
		// id
		if (eventbrite.containsKey("id"))
		{
			e.setEvent_id(eventbrite.get("id").toString());
		}
		
		// event_url
		if (eventbrite.containsKey("url"))
		{
			e.setEvent_url(eventbrite.get("url").toString());
		}
		// name
		if (eventbrite.containsKey("name"))
		{
			JSONObject name = (JSONObject)eventbrite.get("name");
			e.setName(name.get("html").toString());
		}
		//capacity
		if (eventbrite.containsKey("capacity"))
		{
			e.setRsvpLimit(Long.parseLong(eventbrite.get("capacity").toString()));
		}
		// status
		if (eventbrite.containsKey("status"))
		{
			e.setStatus(eventbrite.get("status").toString());
		}
		// starttime
		if (eventbrite.containsKey("start"))
		{
			JSONObject start_time = (JSONObject)eventbrite.get("start");
			Date start = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(start_time.get("local").toString().replaceAll("Z$", "+0000"));
			e.setStarttime(start);
			e.setTimezone(start_time.get("timezone").toString());
		}
		// endttime
		if (eventbrite.containsKey("end"))
		{
			JSONObject end_time = (JSONObject)eventbrite.get("end");
			Date end = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(end_time.get("local").toString().replaceAll("Z$", "+0000"));
			e.setStarttime(end);
		}
		
		//logo
		if (eventbrite.get("logo")!= null)
		{
			JSONObject logo = (JSONObject)eventbrite.get("logo");
			e.setLogoURL(logo.get("url").toString());
		}
		
		
		if (eventbrite.containsKey("venue_id"))
		{
			String venue_path_code="/v3/venues/"+eventbrite.get("venue_id").toString()+"/";
			try {
				venues= ebg.getVenue(venue_path_code, key);
				JSONObject venue;
				venue = (JSONObject)parser.parse(venues);
				JSONObject address = (JSONObject)venue.get("address");
				
				String [] venue_details ={"address_1","address_2","address_3","city","country","lat","lon","name","phone","repinned","state","id","zip"}; 
				Venue ven  = new Venue();
				//address_1
				if (address.get("address_1")!= null)
				{
					ven.setAddress1(address.get("address_1").toString());
				}
				//address_2
				if (address.get("address_2") != null)
				{
					ven.setAddress2(address.get("address_2").toString());
				}
				//address_3
				if (address.containsKey("address_3"))
				{
					ven.setAddress3(address.get("address_3").toString());
				}
				//city
				if (address.containsKey("city"))
				{
					ven.setCity(address.get("city").toString());
				}
				//country
				if (address.containsKey("country"))
				{
					ven.setCountry(address.get("country").toString());
				}
				//lat
				if (address.containsKey("latitude"))
				{
					ven.setLat(address.get("latitude").toString());
				}
				//lon
				if (address.containsKey("longitude"))
				{
					ven.setLon(address.get("longitude").toString());
				}
				//name
				if (venue.get("name")!= null)
				{
					ven.setName(venue.get("name").toString());
				}
										
				//region
				if (address.get("region")!=null)
				{
					ven.setState(address.get("region").toString());
				}
				//id
				if (venue.containsKey("id"))
				{
					ven.setVenueId(venue.get("id").toString());
				}
				//zip
				if (address.get("postal_code") != null)
				{
					ven.setZip(address.get("postal_code").toString());
				}
				e.setVenue(ven);
			} catch (Exception ewe) {
				// TODO Auto-generated catch block
				ewe.printStackTrace();
			}

		}
		if (eventbrite.containsKey("organizer_id"))
		{
			String org_path_code="/v3/organizers/"+eventbrite.get("organizer_id").toString()+"/";
			try {
				organization= ebg.getVenue(org_path_code, key);
				JSONObject group;
				group = (JSONObject)parser.parse(organization);
				EventGroup eg = new EventGroup();
				
				//id
				if (group.containsKey("id"))
				{
					eg.setGroupId(group.get("id").toString());
				}
				
				//urlname
				if (group.containsKey("url"))
				{
					eg.setGroupUrl(group.get("url").toString());
				}
				
				//name
				if (group.get("name")!= null)
				{
					eg.setName(group.get("name").toString());
				}
				e.setEventGroup(eg);
			} catch (Exception ewe) {
				// TODO Auto-generated catch block
				ewe.printStackTrace();
			}

		}

		return e;
	}
}


