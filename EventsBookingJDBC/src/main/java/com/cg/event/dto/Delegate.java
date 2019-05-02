package com.cg.event.dto;

import java.util.List;


public class Delegate
{
	
	private String name;
	private Address address;
	private List<Event> events;
		
	public Delegate(String name, Address address, List<Event> events) {
		super();
		this.name = name;
		this.address = address;		
		this.events = events;
	}
	
	public Delegate() {
		// TODO Auto-generated constructor stub
	}
	
	 
		// TODO Auto-generated constructor stub
	 

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	@Override
	public String toString() {
		return "\nDelegate [name=" + name + ", address=" + address + ", events=" + events + "]";
	}	
				
}
