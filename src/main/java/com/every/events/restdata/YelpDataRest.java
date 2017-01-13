package com.every.events.restdata;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.every.events.model.EventGroup;
import com.every.events.model.Events;
import com.every.events.model.Venue;
import com.every.events.model.YelpLocation;

public class YelpDataRest {

	public static ArrayList<YelpLocation> getEventsObj(String city, String topics) {
		ArrayList<YelpLocation> yelps_obj = new ArrayList<YelpLocation>();
		YelpAPI yelp = new YelpAPI();
		String events = "";

		events = yelp.searchForBusinessesByLocation(topics, city);
		System.out.println(" "+events);
		try {
			yelps_obj = DecodeJSON(events);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return yelps_obj;
	}

	public static ArrayList<YelpLocation> getEventsObjById(String businessId) {
		ArrayList<YelpLocation> yelps_obj = new ArrayList<YelpLocation>();
		YelpAPI yelp = new YelpAPI();
		String events = "";

		events = yelp.searchByBusinessId(businessId);
		System.out.println(" "+events);
		try {
			yelps_obj = DecodeJSONById(events);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return yelps_obj;
	}

	
	public static ArrayList<YelpLocation> DecodeJSON(String events) throws java.text.ParseException{
		ArrayList<YelpLocation> events_obj = new ArrayList<YelpLocation>();
		JSONParser parser = new JSONParser();
		JSONObject obj;
		try {
			obj = (JSONObject) parser.parse(events);
			JSONArray results = (JSONArray) obj.get("businesses");
			Iterator i = results.iterator();
			System.out.println(results.size());
			while(i.hasNext())
			{
				YelpLocation e = new YelpLocation();
				JSONObject yelpdata= (JSONObject) i.next();
//				System.out.println(yelpdata);
				//created
				
				// description
				if (yelpdata.containsKey("snippet_text"))
				{
					e.setSnippet_text(yelpdata.get("snippet_text").toString());
				}
				
				// rating
				if (yelpdata.containsKey("rating"))
				{
					e.setRating(yelpdata.get("rating").toString());
				}
				
				// mobile_url
				if (yelpdata.containsKey("mobile_url"))
				{
					e.setMobileURL(yelpdata.get("mobile_url").toString());
				}
				// name
				if (yelpdata.containsKey("name"))
				{

					e.setName(yelpdata.get("name").toString());
				}
				//rating_img_url_small
				if (yelpdata.containsKey("rating_img_url_small"))
				{
					e.setRatingImgUrl(yelpdata.get("rating_img_url_small").toString());
				}
				// rating_img_url
				if (yelpdata.containsKey("rating_img_url"))
				{
					e.setRatingImgUrlLarge(yelpdata.get("rating_img_url").toString());
				}
				// review_count
				if (yelpdata.containsKey("review_count"))
				{
					e.setReviewCount(yelpdata.get("review_count").toString());
				}
				// url
				if (yelpdata.containsKey("url"))
				{
					e.setUrl(yelpdata.get("url").toString());
				}
				
				//image_url
				if (yelpdata.get("image_url")!= null)
				{
					e.setImageURL(yelpdata.get("image_url").toString());
				}
				//id
				if (yelpdata.get("id")!= null)
				{
					e.setYelpid(yelpdata.get("id").toString());
				}
				//id
				if (yelpdata.get("snippet_image_url")!= null)
				{
					e.setSnippetImgUrl(yelpdata.get("snippet_image_url").toString());
				}
				//display_phone
				if (yelpdata.get("display_phone")!= null)
				{
					e.setDisplayPhone(yelpdata.get("display_phone").toString());
				}
				
				
				
				
				if (yelpdata.containsKey("location"))
				{
					JSONObject address = (JSONObject) yelpdata.get("location");
					if (address.get("postal_code")!= null)
						{
							e.setPostalCode(address.get("postal_code").toString());
						}
						//address_2
						if (address.get("city") != null)
						{
							e.setCity(address.get("city").toString());
						}
						//address_3
						if (address.containsKey("state_code"))
						{
							e.setState(address.get("state_code").toString());
						}
						//city
						if (address.containsKey("country_code"))
						{
							e.setCountry(address.get("country_code").toString());
						}
						//coordinate
						if (address.containsKey("coordinate"))
						{
							JSONObject coor = (JSONObject)address.get("coordinate");
							
							e.setLat(coor.get("latitude").toString());
								
							e.setLon(coor.get("longitude").toString());
						}
						//lat
						if (address.containsKey("display_address"))
						{
							JSONArray coor = (JSONArray)address.get("display_address");
							
							e.setDisplayadd1(coor.get(0).toString());
								
							e.setDisplayadd2(coor.get(1).toString());
						}
				}
				events_obj.add(e);
			}
						
			}
		catch (Exception e) {
			System.out.println(e);// TODO: handle exception
		}
						return events_obj;
		}
	
	
	
	public static ArrayList<YelpLocation> DecodeJSONById(String events) throws java.text.ParseException{
		ArrayList<YelpLocation> events_obj = new ArrayList<YelpLocation>();
		JSONParser parser = new JSONParser();
		JSONObject obj;
		try {
			JSONObject yelpdata = (JSONObject) parser.parse(events);
//			JSONObject object=(JSONObject) obj.get("rating");
			System.out.println(Double.parseDouble(yelpdata.get("rating").toString()));

				YelpLocation e = new YelpLocation();

				if (yelpdata.containsKey("snippet_text"))
				{
					e.setSnippet_text(yelpdata.get("snippet_text").toString());
				}
				
				// rating
				if (yelpdata.containsKey("rating"))
				{
					e.setRating(yelpdata.get("rating").toString());
				}
				
				// mobile_url
				if (yelpdata.containsKey("mobile_url"))
				{
					e.setMobileURL(yelpdata.get("mobile_url").toString());
				}
				// name
				if (yelpdata.containsKey("name"))
				{

					e.setName(yelpdata.get("name").toString());
				}
				//rating_img_url_small
				if (yelpdata.containsKey("rating_img_url_small"))
				{
					e.setRatingImgUrl(yelpdata.get("rating_img_url_small").toString());
				}
				// rating_img_url
				if (yelpdata.containsKey("rating_img_url"))
				{
					e.setRatingImgUrlLarge(yelpdata.get("rating_img_url").toString());
				}
				// review_count
				if (yelpdata.containsKey("review_count"))
				{
					e.setReviewCount(yelpdata.get("review_count").toString());
				}
				// url
				if (yelpdata.containsKey("url"))
				{
					e.setUrl(yelpdata.get("url").toString());
				}
				
				//image_url
				if (yelpdata.get("image_url")!= null)
				{
					e.setImageURL(yelpdata.get("image_url").toString());
				}
				//id
				if (yelpdata.get("id")!= null)
				{
					e.setYelpid(yelpdata.get("id").toString());
				}
				//id
				if (yelpdata.get("snippet_image_url")!= null)
				{
					e.setSnippetImgUrl(yelpdata.get("snippet_image_url").toString());
				}
				//display_phone
				if (yelpdata.get("display_phone")!= null)
				{
					e.setDisplayPhone(yelpdata.get("display_phone").toString());
				}
				
				
				
				
				if (yelpdata.containsKey("location"))
				{
					JSONObject address = (JSONObject) yelpdata.get("location");
					if (address.get("postal_code")!= null)
						{
							e.setPostalCode(address.get("postal_code").toString());
						}
						//address_2
						if (address.get("city") != null)
						{
							e.setCity(address.get("city").toString());
						}
						//address_3
						if (address.containsKey("state_code"))
						{
							e.setState(address.get("state_code").toString());
						}
						//city
						if (address.containsKey("country_code"))
						{
							e.setCountry(address.get("country_code").toString());
						}
						//coordinate
						if (address.containsKey("coordinate"))
						{
							JSONObject coor = (JSONObject)address.get("coordinate");
							
							e.setLat(coor.get("latitude").toString());
								
							e.setLon(coor.get("longitude").toString());
						}
						//lat
						if (address.containsKey("display_address"))
						{
							JSONArray coor = (JSONArray)address.get("display_address");
							
							e.setDisplayadd1(coor.get(0).toString());
								
							e.setDisplayadd2(coor.get(1).toString());
						}
				}
				events_obj.add(e);
		
			}
		catch (Exception e) {
			System.out.println(e);// TODO: handle exception
		}
						return events_obj;
		}
	
	
	
}
