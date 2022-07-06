package org.spirit.events.dataaccess.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.spirit.events.dataaccess.models.EventsDetails;
import org.spirit.events.dataaccess.repositories.EventsRepository;
import org.spirit.events.dataaccess.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService{

	@Autowired
	private EventsRepository eventrepo;

	@Override
	public List<EventsDetails> getAllEvents() {
		
		List<EventsDetails> eventsInfo = new ArrayList<EventsDetails>(); 
		
		for(EventsDetails a : eventrepo.findAll()) {
			eventsInfo.add(a);
		}
		
		return eventsInfo;
	}

	@Override
	public List<EventsDetails> getEventByEventCategoryId(int eventCategoryId) {
		
		return eventrepo.findEventsDetailsByEventCategoryId(eventCategoryId);
	}



	@Override
	public List<EventsDetails> getEventByEventName(String eventName) {
		return eventrepo.findEventsDetailsByEventName(eventName);
	}

	@Override
	public EventsDetails getEventByEventId(int eventId) {
		return eventrepo.findById(eventId).orElse(null);
	}

	@Override
	public List<EventsDetails> getEventByLocation(String location) {
		List<EventsDetails> locEve = eventrepo.findEventsDetailsByLocation(location);
		return locEve;
	} 
	
	
	@Override
	public EventsDetails createEvent(Map<String, String> eve1, int categoryId) {
		
		EventsDetails event = new EventsDetails(); 
		event.setEventCategoryId(categoryId);
		event.setDateInfo(eve1.get("dateInfo"));
		event.setEventName(eve1.get("eventName"));
		event.setLocation(eve1.get("location"));
		event.setOverview(eve1.get("overview"));
		event.setEventDoc(eve1.get("eventDoc"));
		event.setUrl(eve1.get("url"));
		System.out.println(event);
		event = eventrepo.save(event); 
		return event; 
	}
	
	
	@Override
	public String deleteEvent(EventsDetails eve) {
		String message = "";
		if(eve != null) {
		eventrepo.delete(eve);
		message = "successfully deleted the entry";
		}
		return message;
		
	}
}
