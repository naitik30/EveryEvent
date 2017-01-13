package com.every.events.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class EventGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long id;


	@Column
	public String groupLat;


	@Column
	public String groupLon;


	@Column
	public Date created;

	// Group photo

	// photos


	@Column
	public String groupId;


	@Column
	public String name;

	@Column
	public String topic;

	@Column
	public String groupUrl;
	
	@ManyToOne
	public GroupPhoto groupPhoto;

	@OneToMany(mappedBy="eventGroup")
	public Collection<Photos> photos;

	public GroupPhoto getGroupPhoto() {
		return groupPhoto;
	}

	public void setGroupPhoto(GroupPhoto groupPhoto) {
		this.groupPhoto = groupPhoto;
	}

	public Collection<Photos> getPhotos() {
		return photos;
	}

	public void setPhotos(Collection<Photos> photos) {
		this.photos = photos;
	}

	public String getGroupLat() {
		return groupLat;
	}

	public void setGroupLat(String groupLat) {
		this.groupLat = groupLat;
	}

	public String getGroupLon() {
		return groupLon;
	}

	public void setGroupLon(String groupLon) {
		this.groupLon = groupLon;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getGroupUrl() {
		return groupUrl;
	}

	public void setGroupUrl(String groupUrl) {
		this.groupUrl = groupUrl;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
