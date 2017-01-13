package com.every.events.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.every.events.model.Events;
import com.every.events.model.MyLocation;
import com.every.events.model.YelpLocation;
import com.every.events.restdata.EventBriteRest;
import com.every.events.restdata.MeetupRestCall;
import com.every.events.restdata.YelpDataRest;

@Controller
public class PlacesController {

	 @RequestMapping("/placesReq")
	 public ModelAndView placesReq(HttpServletRequest request) {
		 HttpSession session=request.getSession();
		 MyLocation mylocation=(MyLocation) session.getAttribute("locationset");
		 ArrayList<YelpLocation> listOfplaces=new ArrayList<YelpLocation>();
		 YelpDataRest yelprest=new YelpDataRest();
		 String city=mylocation.getCity();
		 city=city.concat(",");
		 city=city.concat(mylocation.getState().toUpperCase());
		 System.out.println("Places Req "+city);
		 listOfplaces=yelprest.getEventsObj(city,"Hotel");
		 return new ModelAndView("places", "listOfplaces", listOfplaces);
	   }


	 @RequestMapping("/placesHotelNearReq")
	 public ModelAndView placesHotelNearReq(HttpServletRequest request) {
		 String city=request.getParameter("city");
		 String state=request.getParameter("state");
		 ArrayList<YelpLocation> listOfplaces=new ArrayList<YelpLocation>();
		 YelpDataRest yelprest=new YelpDataRest();
		 city=city.concat(",");
		 city=city.concat(state.toUpperCase());
		 System.out.println("Places Req "+city);
		 listOfplaces=yelprest.getEventsObj(city,"Hotel");
		 return new ModelAndView("places", "listOfplaces", listOfplaces);
	   }
	 
	 @RequestMapping("/placesRestaurantNearReq")
	 public ModelAndView placesRestaurantNearReq(HttpServletRequest request) {
		 String city=request.getParameter("city");
		 String state=request.getParameter("state");
		 ArrayList<YelpLocation> listOfplaces=new ArrayList<YelpLocation>();
		 YelpDataRest yelprest=new YelpDataRest();
		 city=city.concat(",");
		 city=city.concat(state.toUpperCase());
		 System.out.println("Places Req "+city);
		 listOfplaces=yelprest.getEventsObj(city,"restaurants");
		 return new ModelAndView("places", "listOfplaces", listOfplaces);
	   }
	 
	 
	 @RequestMapping("/searchplacesReq")
	   public ModelAndView searchplacesReq(HttpServletRequest request) {
		  try{  
		  String topic=request.getParameter("topic");
		  String city=request.getParameter("city");
		  String state=request.getParameter("state");
		  
		  city=city.concat(",");
		  city=city.concat(state.toUpperCase());
		  System.out.println("Search Places Method :: "+city);
		  YelpDataRest yelprest=new YelpDataRest();
		  ArrayList<YelpLocation> listOfplaces=new ArrayList<YelpLocation>();
		  listOfplaces=yelprest.getEventsObj(city,topic);
		  return new ModelAndView("places", "listOfplaces", listOfplaces);
		   
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }
		   return new ModelAndView("places", "listOfplaces", null);
	   }
	 
	 @RequestMapping("/searchplacesByIDReq")
	   public ModelAndView searchplacesByIDReq(HttpServletRequest request) {
		  try{  
		   String place_id=request.getParameter("eventID");
		   ArrayList<YelpLocation> listOfplaces=new ArrayList<YelpLocation>();
		   YelpDataRest yelprest=new YelpDataRest();
		   listOfplaces=yelprest.getEventsObjById(place_id);
		   YelpLocation yelpplace=new YelpLocation();
		   yelpplace=listOfplaces.get(0);
		   return new ModelAndView("showPlace", "yelpPlace", yelpplace);
		    
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }
		   return new ModelAndView("showPlace", "yelpPlace", null);
	   }
	 
	 
}
