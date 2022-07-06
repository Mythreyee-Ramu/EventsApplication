package org.spirit.events.dataaccess.services;

import java.util.Map;

public interface BookingService {

	public int getBookingsInfoByName(int Id);

	String addBookingEntry(Map<String, Integer> bookingInfo, String eventName);
	
	void deleteEntry(int id);
	
}
