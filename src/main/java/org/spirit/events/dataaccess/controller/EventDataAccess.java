package org.spirit.events.dataaccess.controller;


import java.util.List;
import java.util.Map;

import org.spirit.events.dataaccess.models.EventsDetails;
import org.spirit.events.dataaccess.repositories.EventsRepository;
import org.spirit.events.dataaccess.services.BookingService;
import org.spirit.events.dataaccess.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;


@RestController
public class EventDataAccess {

	@Autowired
	private EventService events; 
	
	@Autowired
	private BookingService books;
	
	@Autowired 
	private EventsRepository eventrepos;
	
	@GetMapping("/events")
	public ResponseEntity<Object> listGroups() {
		List<EventsDetails> eventsList = events.getAllEvents();
		return new ResponseEntity<>(eventsList, HttpStatus.OK);
	}
	
	@GetMapping("/events/{eventId}")
	public ResponseEntity<Object> eventById(@PathVariable ("eventId") int eventId){
		EventsDetails eve1 = events.getEventByEventId(eventId);
		return new ResponseEntity<>(eve1, HttpStatus.OK);
	}
	
	@GetMapping("/events/location/{location}")
	public ResponseEntity<Object> eventByLocation(@PathVariable ("location") String location){
		List<EventsDetails> locEve1 = events.getEventByLocation(location); 
		return new ResponseEntity<>(locEve1, HttpStatus.OK);
	}
 
	
	@GetMapping("/{eventName}")
	public ResponseEntity<Object> eventByEventName(@PathVariable ("eventName") String eventName){
		List<EventsDetails> eveName = events.getEventByEventName(eventName);
		return new ResponseEntity<>(eveName, HttpStatus.OK);
	}
	
	@GetMapping("/events/category")
	public ResponseEntity<Object> eventByCategoryId(@RequestBody Map<String, Integer> eventInfo){
		int categoryId = eventInfo.get("eventCategoryId"); 
		List<EventsDetails> eveCat = events.getEventByEventCategoryId(categoryId);
		return new ResponseEntity<>(eveCat, HttpStatus.OK);
	}
	
	@PostMapping("/events/{eventCategoryId}/create")
	public ResponseEntity<Object> createEvent(@RequestBody Map<String, String> eve1, @PathVariable ("eventCategoryId") int eventCategoryId){
		
		List<EventsDetails> eveName = events.getEventByEventName(eve1.get("eventName"));
		if (eveName.isEmpty()) {
		EventsDetails insertedEve =  events.createEvent(eve1, eventCategoryId);
		return new ResponseEntity<>(insertedEve, HttpStatus.OK);
		}
		String msg = "An event with same name already exists, try to with another event name";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/events/delete")
	public ResponseEntity<Object> deleteEvent(@RequestBody String eventName){
		
		List<EventsDetails> eveName = events.getEventByEventName(eventName);
		String msg = "";
		if(!eveName.isEmpty()) {
			for(EventsDetails e : eveName) {
				int id = e.getEventId();
				books.deleteEntry(id);
				msg = events.deleteEvent(e);
			}
		}
		else {
			msg = "This event entry does not exists";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK); 
		
	}
}
