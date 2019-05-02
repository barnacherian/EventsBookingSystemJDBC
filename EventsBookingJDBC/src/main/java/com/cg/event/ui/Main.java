package com.cg.event.ui;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.cg.event.dao.EventRepository;
import com.cg.event.dto.Address;
import com.cg.event.dto.Delegate;
import com.cg.event.dto.Event;
import com.cg.event.exception.DelegateException;
import com.cg.event.service.DelegateService;
import com.cg.event.service.DelegateServiceImpl;
import com.cg.event.util.DBUtil;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class Main
{
	public static void main(String[] args) throws DelegateException
	{		
		Scanner sc=new Scanner(System.in);
		List<Event> delegateEvents= null;
		List<Event> delegateEventsone= null;
		List<Event> delegateEventstwo= null;
		List<Event> zero=null;
	//	final Logger LOGGER = Logger.getLogger("EventLogger");
		DelegateService service=new DelegateServiceImpl();
		List<Event> eve=service.showEvents();  
		System.out.println("The events available are: ");	
		for (Event event : eve)
		{
			System.out.println(event.getEventName()+", "+event.getCity());	//displaying  events from eventlist
			delegateEvents=new ArrayList<Event>(); 					
			delegateEvents.add(eve.get(0));
			delegateEventsone=new ArrayList<Event>();
			delegateEventsone.add(eve.get(1));
			delegateEventstwo=new ArrayList<Event>();
			delegateEventstwo.add(eve.get(2));
		}								
		System.out.println("\nEnter your name");
		String name=sc.next();
		
		System.out.println("enter Address : buiding name");
		String building=sc.next();
		
		System.out.println("enter street");
		String street=sc.next();
		
		System.out.println("enter city");
		String city=sc.next();
		
		System.out.println("Select the event you want to attend 1.Talk show 2.Workshop 3.Cricket Match");
		int attending=sc.nextInt();
		if(attending==1)
		{
			zero=delegateEvents;
		}
		else if(attending==2) {
			zero=delegateEventsone;
		}
		else if(attending==3) {
			zero=delegateEventstwo;
		}

		Delegate d=new Delegate(name,new Address(building,street,city),zero);
		System.out.println(service.registerDelegate(d));                               //register delegate	
			
		System.out.println("\nSelect the event for which info is required 1.Talk show 2.Workshop 3.Cricket Match");  //Event info function 
		int infooption=sc.nextInt();
		try {
		if(infooption==1)
		{
				Event option=delegateEvents.get(0);
				System.out.println(option);
		}
		if(infooption==2)
		{
			Event option=delegateEvents.get(1);
			System.out.println(option);
		}
		if(infooption==3)
		{
			Event option=delegateEvents.get(2);
			System.out.println(option);
		}						
		}catch(Exception e) {
			System.out.println(e.getMessage());
		//	 LOGGER.log(Level.SEVERE, "Error in loading configuration",e);
		}
	}
}