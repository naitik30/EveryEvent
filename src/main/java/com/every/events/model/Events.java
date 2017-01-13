package com.every.events.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Events {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long id;
	@Column
	public Date created;
	@Column
	public String description;
	@Column
	public String logoURL;
	@Column
	public String duration;
	@Column
	public String event_url;
	@Column
	public long capacity;
	@Column
	public String isReservedSeating;
	@Column
	public String name;
	@Column
	public long headCount;
	@Column
	public String howToFindUs;
	@Column
	public String event_id;
	@Column
	public int maybeRsvpCount;
	@Column
	public int rating;
	@Column
	public String status;
	@Column
	public Date starttime;
	@Column
	public Date endtime;
	@Column
	public String timezone;
	@Column
	public Date updated;
	@Column
	public String utcOffset;
	@Column
	public String why;
	@Column
	public long yesCount;
	@Column
	public long rsvpLimit;
	@Column
	public int waitlistCount;
	@Column
	public int yesRsvpCount;
	@Column
	public float amount;
	@Column
	public String currency;
	@Column
	public String descFees;
	@Column
	public String source;
	@ManyToOne
	public Venue venue;
	@ManyToOne
	public EventGroup eventGroup;
	

	@ManyToMany(mappedBy="events")
    private Collection<User> users;
	
	
	
	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	
	public void addUser(User user) {
	        if (!getUsers().contains(user)) {
	            getUsers().add(user);
	        }
	        if (!user.getEvents().contains(this)) {
	            user.getEvents().add(this);
	        }
	    }
	
	

	public Events(){
		users=new ArrayList<User>();
	}
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getLogoURL() {
		return logoURL;
	}
	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}
	public long getCapacity() {
		return capacity;
	}
	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}
	public String getIsReservedSeating() {
		return isReservedSeating;
	}
	public void setIsReservedSeating(String isReservedSeating) {
		this.isReservedSeating = isReservedSeating;
	}
	public Venue getVenue() {
		return venue;
	}
	public void setVenue(Venue venue) {
		this.venue = venue;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getEvent_url() {
		return event_url;
	}
	public void setEvent_url(String event_url) {
		this.event_url = event_url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getHeadCount() {
		return headCount;
	}
	public void setHeadCount(long headCount) {
		this.headCount = headCount;
	}
	public String getHowToFindUs() {
		return howToFindUs;
	}
	public void setHowToFindUs(String howToFindUs) {
		this.howToFindUs = howToFindUs;
	}

	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public EventGroup getEventGroup() {
		return eventGroup;
	}
	public void setEventGroup(EventGroup eventGroup) {
		this.eventGroup = eventGroup;
	}
	public int getMaybeRsvpCount() {
		return maybeRsvpCount;
	}
	public void setMaybeRsvpCount(int maybeRsvpCount) {
		this.maybeRsvpCount = maybeRsvpCount;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String getUtcOffset() {
		return utcOffset;
	}
	public void setUtcOffset(String utcOffset) {
		this.utcOffset = utcOffset;
	}
	public String getWhy() {
		return why;
	}
	public void setWhy(String why) {
		this.why = why;
	}
	public long getYesCount() {
		return yesCount;
	}
	public void setYesCount(long yesCount) {
		this.yesCount = yesCount;
	}
	public long getRsvpLimit() {
		return rsvpLimit;
	}
	public void setRsvpLimit(long rsvpLimit) {
		this.rsvpLimit = rsvpLimit;
	}
	public int getWaitlistCount() {
		return waitlistCount;
	}
	public void setWaitlistCount(int waitlistCount) {
		this.waitlistCount = waitlistCount;
	}
	public int getYesRsvpCount() {
		return yesRsvpCount;
	}
	public void setYesRsvpCount(int yesRsvpCount) {
		this.yesRsvpCount = yesRsvpCount;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDescFees() {
		return descFees;
	}
	public void setDescFees(String descFees) {
		this.descFees = descFees;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
}
