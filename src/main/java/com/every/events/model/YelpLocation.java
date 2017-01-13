package com.every.events.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class YelpLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	public Long id;
	

	@Override
	public String toString() {
		return "YelpLocation [id=" + id + ", imageURL=" + imageURL + ", name=" + name + ", rating=" + rating
				+ ", mobileURL=" + mobileURL + ", reviewCount=" + reviewCount + ", url=" + url + ", snippet_text="
				+ snippet_text + ", ratingImgUrl=" + ratingImgUrl + ", snippetImgUrl=" + snippetImgUrl
				+ ", displayPhone=" + displayPhone + ", ratingImgUrlLarge=" + ratingImgUrlLarge + ", country=" + country
				+ ", displayadd1=" + displayadd1 + ", displayadd2=" + displayadd2 + ", lat=" + lat + ", lon=" + lon
				+ ", city=" + city + ", postalCode=" + postalCode + ", state=" + state + ", category=" + category
				+ ", yelpid=" + yelpid + ", getName()=" + getName() + ", getId()=" + getId() + ", getImageURL()="
				+ getImageURL() + ", getRating()=" + getRating() + ", getMobileURL()=" + getMobileURL()
				+ ", getReviewCount()=" + getReviewCount() + ", getUrl()=" + getUrl() + ", getSnippet_text()="
				+ getSnippet_text() + ", getRatingImgUrl()=" + getRatingImgUrl() + ", getSnippetImgUrl()="
				+ getSnippetImgUrl() + ", getDisplayPhone()=" + getDisplayPhone() + ", getRatingImgUrlLarge()="
				+ getRatingImgUrlLarge() + ", getCountry()=" + getCountry() + ", getDisplayadd1()=" + getDisplayadd1()
				+ ", getDisplayadd2()=" + getDisplayadd2() + ", getLat()=" + getLat() + ", getLon()=" + getLon()
				+ ", getCity()=" + getCity() + ", getPostalCode()=" + getPostalCode() + ", getState()=" + getState()
				+ ", getCategory()=" + getCategory() + ", getYelpid()=" + getYelpid() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public YelpLocation(){
		
	}
	public YelpLocation(Long id, String imageURL, String name, String rating, String mobileURL, String reviewCount,
			String url, String snippet_text, String ratingImgUrl, String snippetImgUrl, String displayPhone,
			String ratingImgUrlLarge, String country, String displayadd1, String displayadd2, String lat, String lon,
			String city, String postalCode, String state, String category, String yelpid) {
		super();
		this.id = id;
		this.imageURL = imageURL;
		this.name = name;
		this.rating = rating;
		this.mobileURL = mobileURL;
		this.reviewCount = reviewCount;
		this.url = url;
		this.snippet_text = snippet_text;
		this.ratingImgUrl = ratingImgUrl;
		this.snippetImgUrl = snippetImgUrl;
		this.displayPhone = displayPhone;
		this.ratingImgUrlLarge = ratingImgUrlLarge;
		this.country = country;
		this.displayadd1 = displayadd1;
		this.displayadd2 = displayadd2;
		this.lat = lat;
		this.lon = lon;
		this.city = city;
		this.postalCode = postalCode;
		this.state = state;
		this.category = category;
		this.yelpid = yelpid;
	}

	@Column
	public String imageURL;

	@Column
	public String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public String rating;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getMobileURL() {
		return mobileURL;
	}

	public void setMobileURL(String mobileURL) {
		this.mobileURL = mobileURL;
	}

	public String getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(String reviewCount) {
		this.reviewCount = reviewCount;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSnippet_text() {
		return snippet_text;
	}

	public void setSnippet_text(String snippet_text) {
		this.snippet_text = snippet_text;
	}

	public String getRatingImgUrl() {
		return ratingImgUrl;
	}

	public void setRatingImgUrl(String ratingImgUrl) {
		this.ratingImgUrl = ratingImgUrl;
	}

	public String getSnippetImgUrl() {
		return snippetImgUrl;
	}

	public void setSnippetImgUrl(String snippetImgUrl) {
		this.snippetImgUrl = snippetImgUrl;
	}

	public String getDisplayPhone() {
		return displayPhone;
	}

	public void setDisplayPhone(String displayPhone) {
		this.displayPhone = displayPhone;
	}

	public String getRatingImgUrlLarge() {
		return ratingImgUrlLarge;
	}

	public void setRatingImgUrlLarge(String ratingImgUrlLarge) {
		this.ratingImgUrlLarge = ratingImgUrlLarge;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDisplayadd1() {
		return displayadd1;
	}

	public void setDisplayadd1(String displayadd1) {
		this.displayadd1 = displayadd1;
	}

	public String getDisplayadd2() {
		return displayadd2;
	}

	public void setDisplayadd2(String displayadd2) {
		this.displayadd2 = displayadd2;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getYelpid() {
		return yelpid;
	}

	public void setYelpid(String yelpid) {
		this.yelpid = yelpid;
	}

	@Column
	public String mobileURL;
	
	@Column
	public String reviewCount;
	
	@Column
	public String url;

	@Column
	public String snippet_text;

	@Column
	public String ratingImgUrl;

	@Column
	public String snippetImgUrl;

	@Column
	public String displayPhone;

	@Column
	public String ratingImgUrlLarge;

	@Column
	public String country;

	@Column
	public String displayadd1;

	@Column
	public String displayadd2;

	@Column
	public String lat;

	@Column
	public String lon;

	@Column
	public String city;

	@Column
	public String postalCode;

	@Column
	public String state;

	@Column
	public String category;

	@Column
	public String yelpid;
	
}
