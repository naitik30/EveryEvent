package com.every.events.restdata;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.json.JsonObject;
import javax.print.attribute.standard.DateTimeAtCompleted;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import com.every.events.model.EventGroup;
import com.every.events.model.Events;
import com.every.events.model.GroupPhoto;
import com.every.events.model.Venue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;



public class MeetupRestCall {

	public static ArrayList<Events> geteventsobj(String city, String State,String topics) {
		 
		String key_path = "api.txt"; 							//Path to API Key (api_key.txt)
		String key = "";
		String path_code = "/2/open_events";							//PathCode for get-events
																			//More PathCodes : http://www.meetup.com/meetup_api/docs/
		String events = "";
		Meetup eventGetter = new Meetup();
		key= eventGetter.getApiKey(key_path);
		eventGetter.city = city;
		eventGetter.state = State;
		eventGetter.topic = topics;
		try{
			events = eventGetter.getEvent(path_code, key);
			System.out.println(events);
		}catch(Exception e){e.printStackTrace();}
		ArrayList<Events> events_obj = new ArrayList<Events>();
		events_obj = DecodeJSON(events);
		return events_obj;
	}
 
	public static ArrayList<Events> geteventsobjById(String eventId) {
		 
		String key_path = "api.txt"; 							//Path to API Key (api_key.txt)
		String key = "";
		String path_code = "/2/events";							//PathCode for get-events
											//More PathCodes : http://www.meetup.com/meetup_api/docs/
		String events = "";
		Meetup eventGetter = new Meetup();
		key= eventGetter.getApiKey(key_path);
		eventGetter.event_id=eventId;

		try{
			events = eventGetter.getEvent(path_code, key);
			System.out.println(events);
		}catch(Exception e){e.printStackTrace();}
		ArrayList<Events> events_obj = new ArrayList<Events>();
		events_obj = DecodeJSON(events);
		return events_obj;
	}
	
	public static ArrayList<Events> geteventsobj(String city, String State) {
		 
		String key_path = "api.txt"; 							//Path to API Key (api_key.txt)
		String key = "";
		String path_code = "/2/open_events";								//PathCode for get-events
																			//More PathCodes : http://www.meetup.com/meetup_api/docs/
		String events = "";
		Meetup eventGetter = new Meetup();
		eventGetter.city = city;
		eventGetter.state = State;
		key= eventGetter.getApiKey(key_path);
		try{
			events = eventGetter.getEvent(path_code, key);
		}catch(Exception e){e.printStackTrace();}
		ArrayList<Events> events_obj = new ArrayList<Events>();
		events_obj = DecodeJSON(events);
		return events_obj;
	}
 
	public static ArrayList<Events> geteventsobj(String topics) {
		 
		String key_path = "api.txt"; 							//Path to API Key (api_key.txt)
		String key = "";
		String path_code = "/2/open_events";								//PathCode for get-events
																			//More PathCodes : http://www.meetup.com/meetup_api/docs/
		String events = "";
		Meetup eventGetter = new Meetup();
		eventGetter.topic = topics;
		key= eventGetter.getApiKey(key_path);
		try{
			events = eventGetter.getEvent(path_code, key);
		}catch(Exception e){e.printStackTrace();}
		ArrayList<Events> events_obj = new ArrayList<Events>();
		events_obj = DecodeJSON(events);
		return events_obj;
	}
 
	public static ArrayList<Events> DecodeJSON(String events){
 
		ArrayList<Events> events_obj = new ArrayList<Events>();
		try{
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject) parser.parse(events);
			JSONArray results = (JSONArray) obj.get("results");
			
			String [] event_details ={"created","description","duration","id","event_url","headcount","how_to_find_us","maybe_rsvp_count","name","rsvp_limit",
					"status","time","timezone","updated","utc_offset","why","yes_rsvp_count"};
			 
			Iterator i = results.iterator(); 
			while(i.hasNext()){
				JSONObject event = (JSONObject) i.next();
				Events e = new Events();
				
				// created
				Long created = Long.parseLong(event.get("created").toString());
				Date s = new Date(created);
				e.setCreated(s);
				
				// description
				if (event.containsKey("description"))
				{
					e.setDescription(event.get("description").toString());
				}
				
				// duration
				if (event.containsKey("duration"))
				{
					e.setDuration(event.get("duration").toString());
				}

				// id
				if (event.containsKey("id"))
				{
					e.setEvent_id(event.get("id").toString());
				}
				
				// event_url
				if (event.containsKey("event_url"))
				{
					e.setEvent_url(event.get("event_url").toString());
				}
				
				// headcount
				if (event.containsKey("headcount"))
				{
					e.setHeadCount(Long.parseLong(event.get("headcount").toString()));
				}
				// how_to_find_us
				if (event.containsKey("how_to_find_us"))
				{
					e.setHowToFindUs(event.get("how_to_find_us").toString());
				}
				// maybe_rsvp_count
				if (event.containsKey("maybe_rsvp_count"))
				{
					e.setMaybeRsvpCount(Integer.parseInt(event.get("maybe_rsvp_count").toString()));
				}
				// name
				if (event.containsKey("name"))
				{
					e.setName(event.get("name").toString());
				}
				// rsvp_limit
				if (event.containsKey("rsvp_limit"))
				{
					e.setRsvpLimit(Long.parseLong(event.get("rsvp_limit").toString()));
				}
				// status
				if (event.containsKey("status"))
				{
					e.setStatus(event.get("status").toString());
				}
				// time
				if (event.containsKey("time"))
				{
					Long time = Long.parseLong(event.get("time").toString());
					Date date_time = new Date(created);
					e.setStarttime(date_time);
				}
				
				// timezone
				if (event.containsKey("timezone"))
				{
					e.setTimezone(event.get("timezone").toString());
				}
				
				// utc_offset
				if (event.containsKey("utc_offset"))
				{
					e.setUtcOffset(event.get("utc_offset").toString());
				}
				
				//why
				if (event.containsKey("why"))
				{
					e.setWhy(event.get("why").toString());
				}
				
				//yes_rsvp_count
				if (event.containsKey("yes_rsvp_count"))
				{
					e.setYesCount(Long.parseLong(event.get("yes_rsvp_count").toString()));
				}
				//updated
				if (event.containsKey("updated"))
				{
					Long updated = Long.parseLong(event.get("updated").toString());
					Date date_updated = new Date(updated);
					e.setUpdated(date_updated);
				}
				
				// fee
				if(event.containsKey("fee"))
				{
					JSONObject fee = (JSONObject) event.get("fee");
					//amount
					if (fee.containsKey("amount"))
					{
						
						e.setAmount(Float.parseFloat(fee.get("amount").toString()));
					}
					
					//currency
					if (fee.containsKey("currency"))
					{
						e.setCurrency(fee.get("currency").toString());
					}
					
					//description
					if (fee.containsKey("description"))
					{
						e.setDescription(fee.get("description").toString());
					}
				}
				
				if(event.containsKey("group"))
				{
					String [] group_details ={"created","id","group_lat","group_lon","urlname","name","topic"}; 
					JSONObject group = (JSONObject) event.get("group");
					String key_path = "api.txt"; 							//Path to API Key (api_key.txt)
					String key = "";
					String path_code = "/2/groups";
					
					Meetup meetgroup = new Meetup();
					meetgroup.group_id =group.get("id").toString();
					key = meetgroup.getApiKey(key_path);
					String group_data = "";
					group_data = meetgroup.getGroup(path_code, key);
					
					JSONObject group_obj = (JSONObject) parser.parse(group_data);
					JSONArray group_results = (JSONArray) group_obj.get("results");
					if (group_results.get(0) != null){
					JSONObject org_group = (JSONObject)group_results.get(0);
					if (org_group.containsKey("group_photo")){
						JSONObject group_main_photo = (JSONObject)org_group.get("group_photo");
						e.setLogoURL(group_main_photo.get("highres_link").toString());
					}
					}
					EventGroup eg = new EventGroup();
					
					//id
					if (group.containsKey("id"))
					{
						eg.setGroupId(group.get("id").toString());
					}
					
					//group_lat
					if (group.containsKey("group_lat"))
					{
						eg.setGroupLat(group.get("group_lat").toString());
					}
					
					//group_lon
					if (group.containsKey("group_lon"))
					{
						eg.setGroupLon(group.get("group_lon").toString());
					}
					
					//urlname
					if (group.containsKey("urlname"))
					{
						eg.setGroupUrl(group.get("urlname").toString());
					}
					
					//name
					if (group.containsKey("name"))
					{
						eg.setName(group.get("name").toString());
					}
					
					//topic
					if (group.containsKey("topic"))
					{
						eg.setTopic(group.get("topic").toString());
					}
					//group_photo
					if (group.containsKey("group_photo"))
						
					{
						System.out.println("In group_photo");
						JsonObject groupphoto = (JsonObject)group.get("group_photo");
						GroupPhoto gphoto = new GroupPhoto();
						//highres_link
						if (groupphoto.containsKey("highres_link"))
						{
							gphoto.setHighlessLink(groupphoto.get("highres_link").toString());
							
						}
						
						//photo_id
						if (groupphoto.containsKey("photo_id"))
						{
							gphoto.setPhotoId(groupphoto.get("photo_id").toString());
						}
						
						//photo_link
						if (groupphoto.containsKey("photo_link"))
						{
							gphoto.setPhotoLink(groupphoto.get("photo_link").toString());
						}
						//thumb_link
						if (groupphoto.containsKey("thumb_link"))
						{
							gphoto.setThumbLink(groupphoto.get("thumb_link").toString());
						}
						eg.setGroupPhoto(gphoto);
					}
					e.setEventGroup(eg);
					
				}
				
				if(event.containsKey("venue")){
					JSONObject venue = (JSONObject) event.get("venue");
					String [] venue_details ={"address_1","address_2","address_3","city","country","lat","lon","name","phone","repinned","state","id","zip"}; 
					Venue ven  = new Venue();
					//address_1
					if (venue.containsKey("address_1"))
					{
						ven.setAddress1(venue.get("address_1").toString());
					}
					//address_2
					if (venue.containsKey("address_2"))
					{
						ven.setAddress2(venue.get("address_2").toString());
					}
					//address_3
					if (venue.containsKey("address_3"))
					{
						ven.setAddress3(venue.get("address_3").toString());
					}
					//city
					if (venue.containsKey("city"))
					{
						ven.setCity(venue.get("city").toString());
					}
					//country
					if (venue.containsKey("country"))
					{
						ven.setCountry(venue.get("country").toString());
					}
					//lat
					if (venue.containsKey("lat"))
					{
						ven.setLat(venue.get("lat").toString());
					}
					//lon
					if (venue.containsKey("lon"))
					{
						ven.setLon(venue.get("lon").toString());
					}
					//name
					if (venue.containsKey("name"))
					{
						ven.setName(venue.get("name").toString());
					}
					//repinned
					if (venue.containsKey("repinned"))
					{
						ven.setRepinned(venue.get("repinned").toString());
					}
					
					//state
					if (venue.containsKey("state"))
					{
						ven.setState(venue.get("state").toString());
					}
					//id
					if (venue.containsKey("id"))
					{
						ven.setVenueId(venue.get("id").toString());
					}
					//zip
					if (venue.containsKey("zip"))
					{
						ven.setZip(venue.get("zip").toString());
					}
					e.setVenue(ven);
				}
				events_obj.add(e);			
				
			}
			
 
		}
		catch(Exception e){e.printStackTrace();}
		return events_obj;
	}
	
}
