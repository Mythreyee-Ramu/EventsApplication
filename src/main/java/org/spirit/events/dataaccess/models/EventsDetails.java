package org.spirit.events.dataaccess.models;


import javax.persistence.*;

@Entity (name = "eventsdetails")
@Table ( name = "eventsdetails", schema = "event")
public class EventsDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "eventId",  updatable = false)
	private int eventId;
	
	@Column(name = "eventName")
	private String eventName; 
	
	
	private String location; 
	
	@Column(name = "dateInfo")
	private String dateInfo;
	
	private String overview;
	@Column(name = "eventDoc")
	private String eventDoc; 
	private String url; 
	
	@Column(name = "eventCategoryId")
	private int eventCategoryId;
	
	
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getDateInfo() {
		return dateInfo;
	}
	public void setDateInfo(String dateInfo) {
		this.dateInfo = dateInfo;
	}
	public String getEventDoc() {
		return eventDoc;
	}
	public void setEventDoc(String eventDoc) {
		this.eventDoc = eventDoc;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getEventCategoryId() {
		return eventCategoryId;
	}
	public void setEventCategoryId(int eventCategoryId) {
		this.eventCategoryId = eventCategoryId;
	} 
	
	
}
