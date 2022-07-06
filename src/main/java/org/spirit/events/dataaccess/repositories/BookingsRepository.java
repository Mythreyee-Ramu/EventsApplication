package org.spirit.events.dataaccess.repositories;

import java.util.List;

import org.spirit.events.dataaccess.models.BookingInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingsRepository extends CrudRepository<BookingInfo, Integer> {

	
	public List<BookingInfo> findBookingsByEventId(int eventId);

	public void deleteAllByEventId(int eventId);
	
	
}
