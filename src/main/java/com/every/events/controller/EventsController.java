package com.every.events.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.every.events.model.Events;
import com.every.events.model.MyLocation;
import com.every.events.restdata.EventBriteRest;
import com.every.events.restdata.MeetupRestCall;

@Controller
public class EventsController {

	 @RequestMapping("/eventsReq")
	   public ModelAndView meetupsReq(HttpServletRequest request) {
		 HttpSession session=request.getSession();
		 MyLocation mylocation=(MyLocation) session.getAttribute("locationset");
		 ArrayList<Events> listOfEvents=new ArrayList<Events>();
		 EventBriteRest eventrest=new EventBriteRest();
		 listOfEvents=	eventrest.getEventsObjByCity(mylocation.getCity().toLowerCase());
		 return new ModelAndView("events", "listOfEvents", listOfEvents);
	   }
	 
	 @RequestMapping("/searcheventsReq")
	   public ModelAndView searchEventsReq(HttpServletRequest request) {
		  try{  
		  String topic=request.getParameter("topic");
		  System.out.println("Search Events Method :: "+topic);
		   String city=request.getParameter("city");
		   EventBriteRest eventRest=new EventBriteRest();
		   ArrayList<Events> listOfEvents=new ArrayList<Events>();
			if (topic.equals("") && city!=null) {
				System.out.println("All");
				listOfEvents = eventRest.getEventsObjByCity(city);
			} else if (topic!=null) {
				System.out.println("Other");
				listOfEvents = eventRest.getEventsObj(city, topic.toLowerCase());
			} 
			return new ModelAndView("events", "listOfEvents", listOfEvents);
		   
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }
		   return new ModelAndView("meetups", "listOfEvents", null);
	   }
	 
	 @RequestMapping("/searcheventsByIDReq")
	   public ModelAndView searcheventsByIDReq(HttpServletRequest request) {
		  try{  
		   String event_id=request.getParameter("eventID");
		   EventBriteRest eventRest=new EventBriteRest();
		   Events event=new Events();
		   event=eventRest.getEventsObjByID(event_id);
		   return new ModelAndView("showEvents", "infoEvent", event);
		    
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }
		   return new ModelAndView("showEvents", "infoEvent", null);
	   }
	 
	 
}
