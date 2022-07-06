package org.spirit.events.dataaccess.repositories;

import java.util.List;

import org.spirit.events.dataaccess.models.EventsDetails;
import org.springframework.data.repository.CrudRepository;

public interface EventsRepository extends CrudRepository<EventsDetails, Integer> {

	
	public List<EventsDetails> findEventsDetailsByLocation(String location);
	
	public List<EventsDetails> findEventsDetailsByEventName(String eventName); 
	
	public List<EventsDetails> findEventsDetailsByEventCategoryId(int eventCategoryId);


}
