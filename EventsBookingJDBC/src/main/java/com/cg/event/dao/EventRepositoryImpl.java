package com.cg.event.dao;

import com.cg.event.dto.Event;
import com.cg.event.exception.DelegateException;
import com.cg.event.util.DBUtil;
import com.cg.event.dto.Delegate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cg.event.dto.Delegate;

public class EventRepositoryImpl implements EventRepository {
	public boolean save(Delegate delegate) throws DelegateException {
		Connection connection = DBUtil.getConnection();
		PreparedStatement pstm;
		try {
			pstm = connection.prepareStatement("INSERT INTO address (building,street,city) VALUES (?,?,?)");
			int addressId = 0;		
			pstm.setString(1, delegate.getAddress().getBuilding());
			pstm.setString(2, delegate.getAddress().getStreet());
			pstm.setString(3, delegate.getAddress().getCity());
			pstm.executeUpdate();
			pstm = connection.prepareStatement("select max(a_id) from address");
			ResultSet result = pstm.executeQuery();
			if (result.next()) {
				addressId = result.getInt(1);
			}			
			int delegateId = 0;
			try {		
				pstm = connection.prepareStatement("INSERT INTO delegate(d_name,a_id) VALUES (?,?)");
				pstm.setString(1,delegate.getName());
				pstm.setInt(2,addressId);
				pstm.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
		}
		return true;
	}
	//Completed Show All
	public List<Event> showAllEvents() throws DelegateException {
		ResultSet result = null;
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select e_name,e_city,e_date from events");
			List<Event> events = new ArrayList<Event>();
			result = pstmt.executeQuery();
			while (result.next()) {
				Event event = new Event();
				event.setEventName(result.getString(1));
				event.setCity(result.getString(2));
				event.setDate(result.getDate(3));
				events.add(event);
			}
			return events;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DelegateException();
		} catch (DelegateException e) {
			// TODO Auto-generated catch block
			throw new DelegateException();
		}
		//return null;
	}
	public List<Delegate> showAllDelegates() throws DelegateException {
		ResultSet result = null;
		Delegate del = new Delegate();
		try {
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from delegate");
			List<Delegate> dels = new ArrayList<Delegate>();
			result = pstmt.executeQuery();
			while (result.next()) {
				del.setName(result.getString(1));
				dels.add(del);
			}
			return dels;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DelegateException();
		} catch (DelegateException e) {
			// TODO Auto-generated catch block
			throw new DelegateException();
		}
	}
}