package com.every.events.model;

import java.awt.Event;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.persistence.Table;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import com.every.events.utils.JPAInitEMF;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long id;

	@Column(name = "USERNAME")
	public String username;
	@Column(name = "FIRSTNAME")
	public String firstname;
	@Column(name = "LASTNAME")
	public String lastname;
	@Column(name = "PASSWORD")
	public String password;
	@Column(name = "EMAIL")
	public String email;
	@Column(name = "phone")
	public String phone;
	@Column(name = "DOB")
	public Date dob;
	@Column(name = "GOOGLE_ID")
	public String googleID;
	@Column(name = "GOOGLE_IMAGE_URL")
	public String googleImgUrl;
	@Column(name = "GOOGLE_TOKEN")
	public String googleToken;
	@ManyToOne
	private Role role;

	@ManyToMany 
    @JoinTable(name="USER_EVENTS",  joinColumns=@JoinColumn(name="USER_ID"),  inverseJoinColumns=@JoinColumn(name="EVENTS_ID"))
    private Collection<Events> events;
	
    public User(){
    	events=new ArrayList<Events>();
    }
	
    
    
    
	public Collection<Events> getEvents() {
		return events;
	}




	public void setEvents(Collection<Events> events) {
		this.events = events;
	}


	public void addEvents(Events event) {
        if (!getEvents().contains(event)) {
            getEvents().add(event);
        }
        if (!event.getUsers().contains(this)) {
        	event.getUsers().add(this);
        }
    }


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGoogleID() {
		return googleID;
	}

	public void setGoogleID(String googleID) {
		this.googleID = googleID;
	}

	public String getGoogleImgUrl() {
		return googleImgUrl;
	}

	public void setGoogleImgUrl(String googleImgUrl) {
		this.googleImgUrl = googleImgUrl;
	}

	public String getGoogleToken() {
		return googleToken;
	}

	public void setGoogleToken(String googleToken) {
		this.googleToken = googleToken;
	}




	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [ username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", password="
				+ password + ", email=" + email + ", dob=" + dob + "]";
	}

	public User userByEmail(String email) {
		try {
			JPAInitEMF jpa = new JPAInitEMF();
			List<User> list = jpa.getEm().createQuery("SELECT u from User u where u.email LIKE :e")
					.setParameter("e", email).getResultList();
			User u = new User();
			if (list == null) {
				return null;
			}
			return (User) list.get(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No Data Found");
		}
		return null;
	}

	public void updateUser(User user){
		JPAInitEMF jpa=new JPAInitEMF();
		User old=new User();
		try{
		if(jpa.getEm().find(User.class,user.getId())==null){
			System.out.println("USer Class No Data Found");
		}else{
			user=jpa.getEm().find(User.class, user.getId());
			jpa.updateEntity(user);
		}	
		}catch(Exception e){
			System.out.println("USER Entity Update user"+e.getMessage());
		}
	}
	
	
	public ArrayList<User> allUsers(){
		JPAInitEMF jpa=new JPAInitEMF();
		List<Object> listUsers=jpa.queryEntities("SELECT t from User t");
		ArrayList<User> userlist=new ArrayList<User>();
		 for (Object object : listUsers) {
			 	userlist.add((User)object);
	    }
		return userlist; 
	}
}
