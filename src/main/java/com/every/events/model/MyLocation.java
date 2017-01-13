package com.every.events.model;

import java.io.Serializable;

public class MyLocation implements Serializable{
	public String city;
	public String state;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public MyLocation(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}
	
}
