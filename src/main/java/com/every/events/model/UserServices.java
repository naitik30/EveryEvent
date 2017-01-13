package com.every.events.model;

import java.util.Collection;

import javax.persistence.Query;

import com.every.events.utils.JPAInitEMF;

public class UserServices {

	public Events createEvent(Events event){
		JPAInitEMF jpa=new JPAInitEMF();
		jpa.InsertEntity(event);
		return event;
	}
	
	 public  Collection<Events> findAllEvents() {
		    JPAInitEMF jpa=new JPAInitEMF();
			Query query = jpa.getEm().createQuery("select e from Events e");
		    return (Collection<Events>) query.getResultList();
    }
	
	 
	public User createUser(User user) {
		JPAInitEMF jpa=new JPAInitEMF();
		jpa.InsertEntity(user);
		return user;
    }

	
	  public User addUserEvent(Long userId, Long eventId) {
			JPAInitEMF jpa=new JPAInitEMF();
			System.out.println(""+userId + eventId);
		    User user=jpa.getEm().find(User.class, userId);
		    Events event=jpa.getEm().find(Events.class, eventId);
		    event.addUser(user);
		    return user;
	  }
	
	  public Collection<User> findAllUsers() {
		  JPAInitEMF jpa=new JPAInitEMF();
		    Query query = jpa.getEm().createQuery("SELECT u FROM User u");
		    return (Collection<User>) query.getResultList();
	   }
	  
}
