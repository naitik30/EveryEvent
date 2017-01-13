package com.every.events.model;



import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.every.events.utils.JPAInitEMF;
public class Main1 {
	  private static final String PERSISTENCE_UNIT_NAME = "per";
	  private static EntityManagerFactory factory;

	  public static void main(String[] args) {
//	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//	    EntityManager em = factory.createEntityManager();
	  
	    UserServices us=new UserServices();
	    User user=new User();
	    user=user.userByEmail("bhagyesh18@gmail.com");
	    
	    Events event=new Events();
	    JPAInitEMF jpa=new JPAInitEMF();
	    List<Object> list=jpa.queryEntities("SELECT e FROM Events e");
	    event=(Events) list.get(0);	    
//	    em.getTransaction().begin();
	    user=us.addUserEvent(user.getId(), event.getId());
	    jpa.updateEntity(user);
	    jpa.updateEntity(event);
	    Collection<User> users=us.findAllUsers();
	    for (User user2 : users) {
			System.out.println(""+user2.getEmail());
		}
	    
	    Collection<Events> events=us.findAllEvents();
	    for (Events events2 : events) {
	    	System.out.println(""+events2.getName());
		}
	    //	    user=user.userByEmail("bhagyesh18@gmail.com");
//	    em.find(User.class,user.getId());
//System.out.println("   " +user.getPassword());
//	    user.setPassword("bhagyesh");
//	    em.merge(user);
//	    em.getTransaction().commit();
	  }
	} 