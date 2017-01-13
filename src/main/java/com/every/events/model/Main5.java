package com.every.events.model;

import java.util.ArrayList;

import com.every.events.restdata.EventBriteRest;
import com.every.events.restdata.MeetupRestCall;

public class Main5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventBriteRest rest=new EventBriteRest();
		ArrayList<Events> listOfEvents=new ArrayList<Events>();
		Events event=new Events();
		event=rest.getEventsObjByID("26228433952");
		
		//System.out.print(listOfEvents.size());
		//for (Events events : listOfEvents) {
			System.out.println("Event Logo URL :: "+event.getLogoURL());
			System.out.println("Name :: "+event.getName());
			System.out.println("EventURL :: "+event.getEvent_url());
			System.out.println("Amount ::" +event.amount);
			System.out.println("Capacity ::"+event.capacity);
			System.out.println("Currency ::"+event.currency);
			System.out.println("DescFees ::"+event.descFees);
			System.out.println("Desc ::"+event.description);
			System.out.println("duration ::"+event.duration);
			System.out.println("evnet id ::"+event.event_id);
			System.out.println("event URL ::"+event.event_url);
			System.out.println("headcount ::"+event.headCount);
			System.out.println("howtofindus ::"+event.howToFindUs);
			System.out.println("is reserved ::"+event.isReservedSeating);
			System.out.println("logo URL ::"+event.logoURL);
			System.out.println("maybersvp ::"+event.maybeRsvpCount);
			System.out.println("name ::"+event.name);
			System.out.println("rating ::"+event.rating);
			System.out.println("rsvplimit v"+event.rsvpLimit);
			System.out.println("source ::"+event.source);
			System.out.println("status ::"+event.status);
			System.out.println("timezone ::"+event.timezone);
			System.out.println("utcoffset ::"+event.utcOffset);
			System.out.println("waitlist  ::"+event.waitlistCount);
			System.out.println("why ::"+event.why);
			System.out.println("yescount ::"+event.yesCount);
			System.out.println("yesrsvpcount ::"+event.yesRsvpCount);

			System.out.println("add1 ::"+event.getVenue().address1);

			System.out.println("add2 ::"+event.getVenue().address2);

			System.out.println("add3 ::"+event.getVenue().address3);

			System.out.println("city ::"+event.getVenue().city);

			System.out.println("country ::"+event.getVenue().country);

			System.out.println("lat ::"+event.getVenue().lat);

			System.out.println("lon ::"+event.getVenue().lon);

			System.out.println("name ::"+event.getVenue().name);

			System.out.println("Phone ::"+event.getVenue().phone);

			System.out.println("Phone ::"+event.getVenue().phone);

			System.out.println("State ::"+event.getVenue().state);

			System.out.println("Zip ::"+event.getVenue().zip);
//		//}
	}

}
