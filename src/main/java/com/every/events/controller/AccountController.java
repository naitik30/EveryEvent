package com.every.events.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.every.events.model.Events;
import com.every.events.model.User;
import com.every.events.utils.JPAInitEMF;

@Controller
public class AccountController {

	   @RequestMapping("/accountReq")
	   public ModelAndView hello(HttpServletRequest request) {
		   HttpSession session=request.getSession();
		   User user=(User)session.getAttribute("userSession");
		   return new ModelAndView("myAccount", "userInfo", user);
	   }

	   @RequestMapping("/showAllUsers")
	   public ModelAndView showAllUsers(HttpServletRequest request) {
		   ArrayList<User> listuser=new ArrayList<User>();
		   listuser=new User().allUsers();
		   return new ModelAndView("showUsers", "listusers", listuser);
	   }
	   
	   
	   @RequestMapping("/deleteUserReq")
	   public ModelAndView deleteUser(HttpServletRequest request) {
		   String email=request.getParameter("email");
		   User u=new User();
		   u=u.userByEmail(email);
		   JPAInitEMF jpa=new JPAInitEMF();
		   jpa.deleteEntity(u);
		   ArrayList<User> listuser=new ArrayList<User>();
		   listuser=new User().allUsers();
		   return new ModelAndView("showUsers", "listusers", listuser);
	   }
	
	   @RequestMapping("/showUserReq")
	   public ModelAndView showUser(HttpServletRequest request) {
		   User u=new User();
		   u=u.userByEmail(request.getParameter("email"));
		   return new ModelAndView("showuserinfo", "userInfo", u);
	   }
	   
	   @RequestMapping("/showMyEventsReq")
	   public ModelAndView showMyEventsReq(HttpServletRequest request) {
		   HttpSession session=request.getSession();
		   User u=new User();
		   u=(User)session.getAttribute("userSession");
		   u=u.userByEmail(u.getEmail());
		   Collection<Events> list=new ArrayList<Events>();
		   list=u.getEvents();
		   
		   
		   return new ModelAndView("goingEvents", "userEvents", list);
	   }
	   
	   
	   
	   
}
