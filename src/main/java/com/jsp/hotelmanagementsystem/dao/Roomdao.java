package com.jsp.hotelmanagementsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotelmanagementsystem.dto.Room;
import com.jsp.hotelmanagementsystem.repo.Roomrepo;

@Repository
public class Roomdao {
	@Autowired
	private Roomrepo roomrepo;
	
	public  Room saveRoom(Room room) {
		return roomrepo.save(room);
		
	}
	public Room updateRoom(Room room) {
		return roomrepo.save(room);
		
	}
	public Room deleteRoom(Room room) {
		roomrepo.delete(room);
		return room;
	
	}
	public Room getroombyid(int id) {
		if(roomrepo.findById(id).isPresent())
		{
			return roomrepo.findById(id).get();
		}
		else {
		return null;
		}
		
	}
	
	public List<Room> getallrooms()
	{
		return roomrepo.findAll();
	}
	
	public List<Room> getroombytype(String room_type) {
		List<Room> list=roomrepo.getroombytype(room_type);
		if(list != null)
		{
			return list;
		}
		else {
		return null;
		}
		
	}
	
	public Room getroombyno(String roomno) {
		Room room=roomrepo.getroombyno(roomno);
		if(room!=null) {
			return room;
		}else {
			return null;
		}
		
	}
	
	public List<Room> getroombyavailability(String availability) {
		return roomrepo.getroombyavailability(availability);
			
		}
	

}
