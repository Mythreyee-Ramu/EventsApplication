package org.spirit.events.dataaccess.controller;

import java.util.Map;

import org.spirit.events.dataaccess.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

	@Autowired 
	private BookingService bookservice; 
	
	/**
	 * Method to get booking count by event Name
	 * @param eventName
	 * @return 
	 */
	
	@GetMapping("/booking/count")
	public ResponseEntity<Object> getBookingsCount(@RequestBody Map<String, Integer> eventId){
		
		int id = eventId.get("eventId");
		
		int bookingsCount = bookservice.getBookingsInfoByName(id);
		
		return new ResponseEntity<>(bookingsCount,HttpStatus.OK);
	}
	
	@GetMapping("/booking/{eventName}/insert")
	public ResponseEntity<Object> createBookingEntry(@RequestBody Map<String, Integer> bookingInfo, @PathVariable("eventName") String eventName){
		System.out.println(eventName);
		
		String msg = bookservice.addBookingEntry(bookingInfo, eventName); 
		System.out.println(msg);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	
}
