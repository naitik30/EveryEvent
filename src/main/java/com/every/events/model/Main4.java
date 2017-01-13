package com.every.events.model;

import java.util.ArrayList;

import com.every.events.restdata.MeetupRestCall;

public class Main4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MeetupRestCall rest=new MeetupRestCall();
		ArrayList<Events> listOfEvents=new ArrayList<Events>();
		listOfEvents=rest.geteventsobjById("230267736");
		System.out.print(listOfEvents.size());
		for (Events events : listOfEvents) {
//			System.out.println("Event Logo URL :: "+events.getLogoURL());
//			System.out.println("Name :: "+events.getName());
//			System.out.println("EventURL :: "+events.getEvent_url());
//			System.out.println("Amount ::" +events.amount);
//			System.out.println("Capacity ::"+events.capacity);
//			System.out.println("Currency ::"+events.currency);
//			System.out.println("DescFees ::"+events.descFees);
//			System.out.println("Desc ::"+events.description);
//			System.out.println("duration ::"+events.duration);
//			System.out.println("evnet id ::"+events.event_id);
//			System.out.println("event URL ::"+events.event_url);
//			System.out.println("headcount ::"+events.headCount);
//			System.out.println("howtofindus ::"+events.howToFindUs);
//			System.out.println("is reserved ::"+events.isReservedSeating);
//			System.out.println("logo URL ::"+events.logoURL);
//			System.out.println("maybersvp ::"+events.maybeRsvpCount);
//			System.out.println("name ::"+events.name);
//			System.out.println("rating ::"+events.rating);
//			System.out.println("rsvplimit v"+events.rsvpLimit);
//			System.out.println("source ::"+events.source);
//			System.out.println("status ::"+events.status);
//			System.out.println("timezone ::"+events.timezone);
//			System.out.println("utcoffset ::"+events.utcOffset);
//			System.out.println("waitlist  ::"+events.waitlistCount);
//			System.out.println("why ::"+events.why);
//			System.out.println("yescount ::"+events.yesCount);
//			System.out.println("yesrsvpcount ::"+events.yesRsvpCount);
//
//			System.out.println("add1 ::"+events.getVenue().address1);
//
//			System.out.println("add2 ::"+events.getVenue().address2);
//
//			System.out.println("add3 ::"+events.getVenue().address3);
//
//			System.out.println("city ::"+events.getVenue().city);
//
//			System.out.println("country ::"+events.getVenue().country);

			System.out.println("lat ::"+events.getVenue().lat);

			System.out.println("lon ::"+events.getVenue().lon);

//			System.out.println("name ::"+events.getVenue().name);
//
//			System.out.println("Phone ::"+events.getVenue().phone);
//
//			System.out.println("Phone ::"+events.getVenue().phone);
//
//			System.out.println("State ::"+events.getVenue().state);
//
//			System.out.println("Zip ::"+events.getVenue().zip);
	}
	}

}
