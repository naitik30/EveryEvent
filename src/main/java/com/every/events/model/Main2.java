package com.every.events.model;

import java.util.ArrayList;

import com.every.events.restdata.YelpDataRest;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		YelpDataRest rest=new YelpDataRest();
		ArrayList<YelpLocation> listOfEvents=new ArrayList<YelpLocation>();
		listOfEvents=rest.getEventsObjById("san-jose-marriott-san-jose");
		System.out.println(listOfEvents.size());
		for (YelpLocation yelp : listOfEvents) {
			//System.out.println(yelp.getYelpid() +"  name : "+yelp.getName() +" address:"+yelp.getDisplayadd1());
			System.out.println(yelp.getSnippetImgUrl()+ "  "+yelp.getReviewCount() +  yelp.getLat()  + yelp.getLon() );
		}
	}
}
