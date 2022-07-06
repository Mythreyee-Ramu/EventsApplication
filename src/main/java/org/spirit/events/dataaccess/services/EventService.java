package org.spirit.events.dataaccess.services;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

import org.spirit.events.dataaccess.models.*;


@Repository
public interface EventService {

	/**
	 * Method to get all events
	 * 
	 * @return - Returns list of matching events 
	 * 
	 */
	public List<EventsDetails> getAllEvents();
	
	
	/**
	 * Method to get the event by eventCategoryId
	 * 
	 * @param eventId
	 * @return - returns particular event matching the event id 
	 * 
	 */
	public List<EventsDetails> getEventByEventCategoryId(int eventCategoryId);
	
	/**
	 * Method to get the event by eventId
	 * @param eventId
	 * @return - returns particular event matching the event id 
	 */
	public EventsDetails getEventByEventId(int eventId);
	
	
	/**
	 * Method to get the list of events by location
	 * 
	 * @param location
	 * @return - returns list of events
	 */
	public List<EventsDetails> getEventByLocation(String location);
	
	/**
	 * 
	 * Method to get list of events by matching event name 
	 * @param eventName
	 * @return - returns list of events
	 */
	public List<EventsDetails> getEventByEventName(String eventName);


	EventsDetails createEvent(Map<String, String> eve1, int categoryId);


	String deleteEvent(EventsDetails eve);
	
}
