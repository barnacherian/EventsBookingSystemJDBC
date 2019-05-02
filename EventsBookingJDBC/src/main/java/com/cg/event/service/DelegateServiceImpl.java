package com.cg.event.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.cg.event.dao.EventRepository;
import com.cg.event.dao.EventRepositoryImpl;
import com.cg.event.dto.Delegate;
import com.cg.event.dto.Event;
import com.cg.event.exception.DelegateException;
import com.cg.event.util.DBUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.cg.event.dao.EventRepository;
import com.cg.event.dao.EventRepositoryImpl;
import com.cg.event.dto.Delegate;
import com.cg.event.dto.Event;
import com.cg.event.exception.DelegateException;
import com.cg.event.util.DBUtil;

	public class DelegateServiceImpl implements DelegateService
	{
		EventRepository dao;
//		Map<Delegate,Event> hm = new HashMap<Delegate,Event>();
		
		public DelegateServiceImpl() {
			dao= new EventRepositoryImpl(); 
			
		}
		public Delegate registerDelegate(Delegate delegate) throws DelegateException 
		{				
			if(dao.save(delegate)==true)
			return delegate;
			else 
				throw new DelegateException("Delegate not added!");
		}
		public List<Event> showEvents() throws DelegateException 
		{	return dao.showAllEvents();	
		}

		public List<Delegate> showDelegates() throws DelegateException
		{	return dao.showAllDelegates();
		}
		
		public Event eventInfo(Event event) throws DelegateException 
		{
			for (Event ee : dao.showAllEvents())
			{
					if(event==dao.showAllEvents().get(0))			
						return dao.showAllEvents().get(0);	
					
					else if(event==dao.showAllEvents().get(1))		
						return dao.showAllEvents().get(1);	
					
					else if(event==dao.showAllEvents().get(2)) 	
						return dao.showAllEvents().get(2);	
					
			}	
			throw new DelegateException("invalid input..no such events in database");			
		}
	}