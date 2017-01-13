package com.every.events.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.persistence.jpa.jpql.tools.ResultQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.every.events.email.EmailServices;
import com.every.events.model.Events;
import com.every.events.model.User;
import com.every.events.model.YelpLocation;
import com.every.events.restdata.EventBriteRest;
import com.every.events.restdata.MeetupRestCall;
import com.every.events.restdata.YelpDataRest;

@Controller
public class EmailController {
	
	 @RequestMapping("/shareEventByMail")
	   public ModelAndView shareEventByMail(HttpServletRequest request) {
		  try{  
		   String event_id=request.getParameter("eventID");
		   String email[] = { request.getParameter("email") };
		   System.out.println(" Email controller "+event_id);
		   System.out.println(" Email controller "+email[0]);
		   EventBriteRest eventRest=new EventBriteRest();
		   Events event=new Events();
		   event=eventRest.getEventsObjByID(event_id);
		   EmailServices emailServices=new EmailServices();
		   HttpSession session=request.getSession();
		   User user=(User)session.getAttribute("userSession");
		   String message="<body style=\"color:#03a9f4;font-family: Verdana\"><h3>Hello</h3><hp> Your Friend <b>"+user.getFirstname()+"</b> has shared an event with you.</p>"+
				      "<hp> Open Following Link to check out the event </p>"
					+ "<p><a style=\"color:#03a9f4;font-family: Verdana\" href=\""+event.getEvent_url()+" \"> "+ event.getName()+" </a></p><p>Thank You</p>"
					+ "<P> For More Information about the events and places visit our website.</p>"
					+ "<p><a style=\"color:#03a9f4;font-family: Verdana\" href=\"http://localhost:8080/EveryEvents/homepage\"> http://localhost:8080/EveryEvents/homepage</a></p>"
					+ "<img src='https://s3.postimg.io/6i3h5logz/Every_Events.jpg'     style='height: 200Px' >"
					+ "</body></html>";   
		   
		   emailServices.sendMail(message,email);
		   return new ModelAndView("showEvents", "infoEvent", event);
		    
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }
		   return new ModelAndView("showEvents", "infoEvent", null);
	   }
	
	 
	 @RequestMapping("/shareMeetupByMail")
	   public ModelAndView shareMeetupByMail(HttpServletRequest request) {
		  try{  
		   String event_id=request.getParameter("eventID");
		   String email[] = { request.getParameter("email") };
		   System.out.println(" Email controller "+event_id);
		   System.out.println(" Email controller "+email[0]);
		   MeetupRestCall meetRest=new MeetupRestCall();
		   Events event=new Events();
		   ArrayList<Events> list=new ArrayList<Events>();
		   list=meetRest.geteventsobjById(event_id);
		   event=list.get(0);
		   EmailServices emailServices=new EmailServices();
		   HttpSession session=request.getSession();
		   User user=(User)session.getAttribute("userSession");
		   String message="<body style=\"color:#03a9f4;font-family: Verdana\"><h3>Hello</h3><hp> Your Friend <b>"+user.getFirstname()+"</b> has shared a Meetup event with you.</p>"+
				      "<hp> Open Following Link to check out the Meetup Event </p>"
					+ "<p><a style=\"color:#03a9f4;font-family: Verdana\" href=\""+event.getEvent_url()+" \"> "+ event.getName()+" </a></p><p>Thank You</p>"
					+ "<P> For More Information about the events and places visit our website.</p>"
					+ "<p><a style=\"color:#03a9f4;font-family: Verdana\" href=\"http://localhost:8080/EveryEvents/homepage\"> http://localhost:8080/EveryEvents/homepage</a></p>"
					+ "<img src='https://s3.postimg.io/6i3h5logz/Every_Events.jpg'     style='height: 200Px' >"
					+ "</body></html>";   
		   
		   emailServices.sendMail(message,email);
		   return new ModelAndView("showmeetup", "meetupEvent", event);
		    
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }
		   return new ModelAndView("showmeetup", "meetupEvent", null);
	   }
	 
	 

	 @RequestMapping("/sharePlacesByMail")
	   public ModelAndView sharePlacesByMail(HttpServletRequest request) {
		  try{  
		   String event_id=request.getParameter("placeID");
		   String email[] = { request.getParameter("email") };
		   System.out.println(" Email controller "+event_id);
		   System.out.println(" Email controller "+email[0]);
		   YelpDataRest yelprest=new YelpDataRest();
		   ArrayList<YelpLocation> list=new ArrayList<YelpLocation>();
		   YelpLocation yelplocation=new YelpLocation();
		   list=yelprest.getEventsObjById(event_id);
		   yelplocation=list.get(0);
		   
		   EmailServices emailServices=new EmailServices();
		   HttpSession session=request.getSession();
		   User user=(User)session.getAttribute("userSession");
		   String message="<body style=\"color:#03a9f4;font-family: Verdana\"><h3>Hello</h3><hp> Your Friend <b>"+user.getFirstname()+"</b> has shared Place with you.</p>"+
				      "<hp> Open Following Link to check out Place </p>"
					+ "<p><a style=\"color:#03a9f4;font-family: Verdana\" href=\""+yelplocation.getUrl()+" \"> "+ yelplocation.getName()+" </a></p><p>Thank You</p>"
					+ "<P> For More Information about the events and places visit our website.</p>"
					+ "<p><a style=\"color:#03a9f4;font-family: Verdana\" href=\"http://localhost:8080/EveryEvents/homepage\"> http://localhost:8080/EveryEvents/homepage</a></p>"
					+ "<img src='https://s3.postimg.io/6i3h5logz/Every_Events.jpg'     style='height: 200Px' >"
					+ "</body></html>";   
		   
		   emailServices.sendMail(message,email);
		   return new ModelAndView("showPlace", "yelpPlace", yelplocation);
		    
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }
		  return new ModelAndView("showPlace", "yelpPlace", null);
	   }
	 
}
