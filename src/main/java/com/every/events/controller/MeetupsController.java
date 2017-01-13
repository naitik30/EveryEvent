package com.every.events.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.every.events.model.Events;
import com.every.events.model.MyLocation;
import com.every.events.model.User;
import com.every.events.restdata.MeetupRestCall;

@Controller
public class MeetupsController {
	
	
	 @RequestMapping("/meetupsReq")
	   public ModelAndView meetupsReq(HttpServletRequest request) {
		   MeetupRestCall meetuprest=new MeetupRestCall();
		   ArrayList<Events> listOfEvents=new ArrayList<Events>();
		   HttpSession session=request.getSession();
		   MyLocation mylocation=(MyLocation) session.getAttribute("locationset");
		   listOfEvents=meetuprest.geteventsobj(mylocation.getCity(), mylocation.getState(), "Music");
		   return new ModelAndView("meetups", "listOfEvents", listOfEvents);
	   }
	 
	 @RequestMapping("/searchmeetupsReq")
	   public ModelAndView searchMeetupsReq(HttpServletRequest request) {
		  try{  
		  String topic=request.getParameter("topic");
		   String city=request.getParameter("city");
		   String state=request.getParameter("state");
		   MeetupRestCall meetuprest=new MeetupRestCall();
		   ArrayList<Events> listOfEvents=new ArrayList<Events>();
		   
		   
		   if(topic.equals("All")){

			   System.out.println("All Topic");
			   listOfEvents=meetuprest.geteventsobj(city, state);
		   }else if(!topic.equals("All")){
			   System.out.println("Other Topic");
			   listOfEvents=meetuprest.geteventsobj(city, state, topic);
		   }else if(city.equals("") || city==null || state==null || state.equals("")){

			   System.out.println("Just Topic");
			   listOfEvents=meetuprest.geteventsobj(topic);
		   }
		   return new ModelAndView("meetups", "listOfEvents", listOfEvents);
		   
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }
		   return new ModelAndView("meetups", "listOfEvents", null);
	   }
	 
	 
	 @RequestMapping("/searchmeetupsByIDReq")
	   public ModelAndView searchmeetupsByIDReq(HttpServletRequest request) {
		  try{  
		   String event_id=request.getParameter("eventID");
		   MeetupRestCall meetuprest=new MeetupRestCall();
		   ArrayList<Events> listOfEvents=new ArrayList<Events>();
		   listOfEvents=meetuprest.geteventsobjById(event_id);
		   Events event=new Events();
		   event=listOfEvents.get(0);
		   return new ModelAndView("showmeetup", "meetupEvent", event);
		    
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }
		   return new ModelAndView("showmeetup", "meetupEvent", null);
	   }
	 
}
