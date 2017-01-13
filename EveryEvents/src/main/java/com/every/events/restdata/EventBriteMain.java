package com.every.events.restdata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.json.JsonArray;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.every.events.model.Events;

public class EventBriteMain {

	public static void main(String[] args){
		EventBriteGetter ebg = new EventBriteGetter();
		String path_code = "/v3/events/search";
		String key_path= "";
		String key="";
		
		String events = "";
		try {
			events = ebg.getEvent(path_code, key);
			ArrayList<Events> events_obj = new ArrayList<Events>();
			events_obj = DecodeJSON(events);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	public static ArrayList<Events> DecodeJSON(String events) throws java.text.ParseException{
		EventBriteGetter ebg = new EventBriteGetter();
		ArrayList<Events> events_obj = new ArrayList<Events>();
		String key_path= "";
		String key="";
		JSONParser parser = new JSONParser();
		JSONObject obj;
		String organization = "";
		String venues = "";
		
		Events e = new Events();
		
		
		try {
			obj = (JSONObject) parser.parse(events);
			JSONArray results = (JSONArray) obj.get("events");
			Iterator i = results.iterator();
			System.out.println(results.size());
			while(i.hasNext())
			{
				
				JSONObject eventbrite= (JSONObject) i.next();
				String created = (String)eventbrite.get("created").toString();
				System.out.println(created);
				Date s = new SimpleDateFormat("dd/MM/yyyy").parse(created);
				e.setCreated(s);
				
				
				if (eventbrite.containsKey("venue_id"))
				{
					String venue_path_code="/v3/venues/"+eventbrite.get("venue_id").toString()+"/";
					try {
						venues= ebg.getVenue(venue_path_code, key);
						JSONObject venue_obj;
						venue_obj = (JSONObject)parser.parse(venues);
//						System.out.println(venue_obj);
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
						JSONObject org_obj;
						org_obj = (JSONObject)parser.parse(organization);
//						System.out.println(org_obj);
					} catch (Exception ewe) {
						// TODO Auto-generated catch block
						ewe.printStackTrace();
					}

				}
				if (eventbrite.containsKey("logo_id"))
				{
					System.out.println(eventbrite.get("logo_id").toString());

				

				}
				
//				System.out.println(eventbrite.get("resource_uri"));
				
			}
			
			
			
		} catch (ParseException ewe) {
			// TODO Auto-generated catch block
			ewe.printStackTrace();
		}

		return events_obj;
	}
}
