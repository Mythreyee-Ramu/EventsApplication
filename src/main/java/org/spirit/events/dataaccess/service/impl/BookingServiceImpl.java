package org.spirit.events.dataaccess.service.impl;

import org.spirit.events.dataaccess.repositories.BookingsRepository;

import org.spirit.events.dataaccess.repositories.EventsRepository;
import org.spirit.events.dataaccess.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import org.spirit.events.dataaccess.models.*;

@Transactional
@Service
public class BookingServiceImpl implements BookingService {

	
	@Autowired 
	private BookingsRepository repo; 
	
	@Autowired 
	private EventsRepository eve;
	
	@Override
	public int getBookingsInfoByName(int eventId) {
		List<BookingInfo> bookings = repo.findBookingsByEventId(eventId);
		System.out.println(bookings.size());
		
		return repo.findBookingsByEventId(eventId).size();
	}
	
	
	@Override
	public String addBookingEntry(Map<String,Integer> bookingInfo, String eventName) {
		
		String message = "";
		int eventId = 0;
		if(!eventName.isEmpty()) {
			eventId = getEventIdfromName(eventName);
			
			BookingInfo b1 = new BookingInfo(); 
			b1.setEventId(eventId);
			b1.setMaxSeats(bookingInfo.get("maxSeats"));
			b1.setOfferTicket(bookingInfo.get("offerTicket"));
			b1.setPayment(bookingInfo.get("payment"));
			b1.setRegularTicket(bookingInfo.get("regularTicket"));
			b1.setVipTicket(bookingInfo.get("vipTicket"));
			b1 = repo.save(b1);
			if(b1 != null) {
				message = "Success";
			}
		}
		
		
		return message;
		
	}
	
	public int getEventIdfromName(String eventName) {
		int eventId = 0;
		List<EventsDetails> event = eve.findEventsDetailsByEventName(eventName); 
		for(EventsDetails e : event) {
			eventId = e.getEventId(); 
		}
		return eventId;
	}


	@Override
	public void deleteEntry(int eventId) {
		if(eventId != 0) {
			 repo.deleteAllByEventId(eventId);
		}
	}
}
