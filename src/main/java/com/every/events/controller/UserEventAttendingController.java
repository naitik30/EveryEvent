package com.every.events.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.every.events.model.EventGroup;
import com.every.events.model.Events;
import com.every.events.model.GroupPhoto;
import com.every.events.model.User;
import com.every.events.model.UserServices;
import com.every.events.model.Venue;
import com.every.events.restdata.EventBriteRest;
import com.every.events.restdata.MeetupRestCall;
import com.every.events.utils.JPAInitEMF;

@Controller
public class UserEventAttendingController {

	 @RequestMapping("/visitEventsYesByIDReq")
	   public ModelAndView visitEventsYesByIDReq(HttpServletRequest request) {
		  try{  
		   String event_id=request.getParameter("eventID");
		   EventBriteRest eventRest=new EventBriteRest();
		   Events event=new Events();
		   event=eventRest.getEventsObjByID(event_id);
		   JPAInitEMF jpa=new JPAInitEMF();
		   Venue ven=new Venue();
		   ven=event.getVenue();
		   jpa.InsertEntity(ven);
		   event.setVenue(ven);
		   EventGroup eventGroup=new EventGroup();
		   jpa.InsertEntity(eventGroup);
		   event.setEventGroup(eventGroup);
		   event.setDescription(" Desc is not saved as we want updated record only  ");
		   event.setSource("eventbrite");
		   jpa.InsertEntity(event);
		   
		   HttpSession session=request.getSession();
		   User user=(User)session.getAttribute("userSession");
		   UserServices us=new UserServices();
		   us.addUserEvent(user.getId(),event.getId());
		   jpa.updateEntity(user);
		   jpa.updateEntity(event);
		   
		   return new ModelAndView("showEvents", "infoEvent", event);
		    
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }
		   return new ModelAndView("showEvents", "infoEvent", null);
	   }
	
	 @RequestMapping("/visitMeetupsYesByIDReq")
	   public ModelAndView visitMeetupsYesByIDReq(HttpServletRequest request) {
		  try{  
		   String event_id=request.getParameter("eventID");
		   MeetupRestCall meetuprest=new MeetupRestCall();
		   ArrayList<Events> listOfEvents=new ArrayList<Events>();
		   listOfEvents=meetuprest.geteventsobjById(event_id);
		   Events event=new Events();
		   event=listOfEvents.get(0);
		   JPAInitEMF jpa=new JPAInitEMF();
		   Venue ven=new Venue();
		   ven=event.getVenue();
		   jpa.InsertEntity(ven);
		   event.setVenue(ven);
		   
		   EventGroup eventGroup=new EventGroup();
		   jpa.InsertEntity(eventGroup);
		   event.setEventGroup(eventGroup);
		   event.setDescription(" Desc is not saved as we want updated record only  ");
		   event.setSource("meetup");
		   jpa.InsertEntity(event);
		   
		   HttpSession session=request.getSession();
		   User user=(User)session.getAttribute("userSession");
		   UserServices us=new UserServices();
		   us.addUserEvent(user.getId(),event.getId());
		   jpa.updateEntity(user);
		   jpa.updateEntity(event);
		   
		   return new ModelAndView("showmeetup", "meetupEvent", event);
		    
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }
		   return new ModelAndView("showmeetup", "meetupEvent", null);
	   }
	 
	 
}
