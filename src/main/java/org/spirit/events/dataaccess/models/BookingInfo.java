package org.spirit.events.dataaccess.models;

import javax.persistence.*;

@Entity (name = "bookings")
@Table (name = "bookings", schema = "event")
public class BookingInfo {
	
	@Id
	@Column(name = "bookingId")
	private int bookingId;
	
	@Column(name = "eventId")
	private int eventId; 
	
	@Column(name = "vipTicket")
	private int vipTicket;
	
	@Column(name = "regularTicket")
	private int regularTicket; 
	
	@Column(name = "offerTicket")
	private int offerTicket;
	
	@Column(name = "maxseats")
	private int maxSeats; 
	
	@Column(name = "customerId")
	private int customerId;
	
	@Column(name = "payment")
	private int payment; 
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getMaxSeats() {
		return maxSeats;
	}
	public void setMaxSeats(int maxSeats) {
		this.maxSeats = maxSeats;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public int getVipTicket() {
		return vipTicket;
	}
	public void setVipTicket(int vipTicket) {
		this.vipTicket = vipTicket;
	}
	public int getRegularTicket() {
		return regularTicket;
	}
	public void setRegularTicket(int regularTicket) {
		this.regularTicket = regularTicket;
	}
	public int getOfferTicket() {
		return offerTicket;
	}
	public void setOfferTicket(int offerTicket) {
		this.offerTicket = offerTicket;
	}
	
}
