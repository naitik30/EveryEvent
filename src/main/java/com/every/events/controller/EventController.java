package com.every.events.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.every.events.model.Events;
import com.every.events.model.User;
import com.every.events.model.Venue;
import com.every.events.utils.JPAInitEMF;

@Controller
public class EventController {

	   @RequestMapping("/newEvent")
	   public String hello(Model model) {
	       return "createEvents";
	   }

	   @RequestMapping(value="/createEvent")
	   public ModelAndView createEvent(HttpServletRequest request) {
		   try {
		   Events event=new Events();
		   event.setLogoURL(request.getParameter("eventLogo"));
		   event.setName(request.getParameter("name"));
		   event.setDuration(request.getParameter("duration"));
		   event.setTimezone(request.getParameter("timezone"));
		   event.setWhy(request.getParameter("why"));
		   event.setAmount(Float.parseFloat(request.getParameter("amount")));		   
		   DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
		   Date d=  df.parse(request.getParameter("starttimetext"));
	       event.setStarttime(d);
		   
		   event.setRsvpLimit(Long.parseLong(request.getParameter("totalRsvpLimit")));
		   event.setCapacity(Long.parseLong(request.getParameter("capacity")));
		   event.setHeadCount(Long.parseLong(request.getParameter("headCount")));
		   event.setHowToFindUs(request.getParameter("howtofindus"));
		   
		   if(request.getParameter("isReservedSeating1").equals("true")){
			   event.setIsReservedSeating("YES");
		   }else{
			   event.setIsReservedSeating("NO"); 
		   }
		   event.setIsReservedSeating(request.getParameter("isReservedSeating"));
		   event.setDescription(request.getParameter("description"));
		   event.setEvent_url(request.getParameter("eventURL"));
		   
		   Venue venue=new Venue();
		   venue.setAddress1(request.getParameter("address1"));
		   venue.setAddress2(request.getParameter("address2"));
		   venue.setAddress3(request.getParameter("address3"));
		   venue.setCity(request.getParameter("city"));
		   venue.setState(request.getParameter("state"));
		   venue.setZip(request.getParameter("zip"));
		   venue.setLon(request.getParameter("lon"));
		   venue.setLat(request.getParameter("lat"));
		   
		   JPAInitEMF jpa=new JPAInitEMF();
		   jpa.InsertEntity(venue);
		   event.setVenue(venue);
		   jpa.InsertEntity(event);
		   
		
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	       return new ModelAndView("createEvents", "isinserted", 1);
	   }
	   
}
