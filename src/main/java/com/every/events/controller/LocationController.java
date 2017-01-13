package com.every.events.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.every.events.model.MyLocation;
import com.every.events.model.Role;
import com.every.events.model.User;

@Controller
public class LocationController {

	 @RequestMapping(value="/setLocation")
	   public ModelAndView setMylocation(HttpServletRequest request) {
	       String city = request.getParameter("city");
	       String state = request.getParameter("state");
	       HttpSession session=request.getSession();
	       session.setAttribute("locationset",new MyLocation(city, state));
	       return new ModelAndView("login", "none", 0);
	   }
}
