package com.jsp.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jsp.hotelmanagementsystem.dao.Hoteldao;
import com.jsp.hotelmanagementsystem.dao.Roomdao;
import com.jsp.hotelmanagementsystem.dto.Hotel;
import com.jsp.hotelmanagementsystem.dto.Room;
import com.jsp.hotelmanagementsystem.util.Responsestructure;



@Service
public class Roomservice {
	@Autowired
	private Roomdao roomdao;
	
	@Autowired
	private Hoteldao hoteldao;
	
	Responsestructure<Room> responsestructure=new Responsestructure<>();
	
	public ResponseEntity<Responsestructure<Room>> saveRoom(Room room, int hid) {
		Hotel hotel = hoteldao.gethotelbyid(hid);
		room.setHotel(hotel);
		Room room2 = roomdao.saveRoom(room);
		if (room2 != null) {
			responsestructure.setMessage("room saved succesfully");
			responsestructure.setStatus(HttpStatus.CREATED.value());
			responsestructure.setData(room2);
			
		}
		return new ResponseEntity<Responsestructure<Room>>(HttpStatus.CREATED);
	}
	
	public ResponseEntity<Responsestructure<Room>> updateroom(Room room,int rid) {
		Room room2=roomdao.getroombyid(rid);
		if(room2!=null) {
			room.setRoomid(rid);
			room.setHotel(room2.getHotel());
			responsestructure.setMessage("room updated succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(roomdao.updateRoom(room));
			return new ResponseEntity<Responsestructure<Room>>(responsestructure,HttpStatus.OK);
		}else {
			return null;
		}
	}
	
	public ResponseEntity<Responsestructure<Room>> deleteroom(int rid) {
		Room room=roomdao.getroombyid(rid);
		if(room!=null) {
			responsestructure.setMessage("room deleted succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(roomdao.deleteRoom(room));
			return new ResponseEntity<Responsestructure<Room>>(responsestructure,HttpStatus.OK);
		}else {
			return null;
		}
	}
	public ResponseEntity<Responsestructure<Room>> getroombyid(int rid) {
		Room room=roomdao.getroombyid(rid);
		if(room!=null) {
			responsestructure.setMessage("room found succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(room);
			return new ResponseEntity<Responsestructure<Room>>(responsestructure,HttpStatus.FOUND);
		}else {
			return null;
		}
	}
	public ResponseEntity<Responsestructure<List<Room>>> getroombytype(String roomtype) {
		Responsestructure<List<Room>> responsestructure=new Responsestructure<>();
		List<Room> list=roomdao.getroombytype(roomtype);
		if(list!=null) {
			responsestructure.setMessage("room found succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(list);
			return new ResponseEntity<Responsestructure<List<Room>>>(responsestructure,HttpStatus.FOUND);
		}else {
			return null;
		}
		
		
	}
	public ResponseEntity<Responsestructure<Room>> getroombyno(String roomno) {
		Room room=roomdao.getroombyno(roomno);
		if(room!=null) {
			responsestructure.setMessage("room found succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(room);
			return new ResponseEntity<Responsestructure<Room>>(responsestructure,HttpStatus.FOUND);
		}else {
			return null;
		}
	}
	public ResponseEntity<Responsestructure<List<Room>>> getroombyavailability(String availability) {
		Responsestructure<List<Room>> responsestructure=new Responsestructure<>();
		List<Room> list=roomdao.getroombyavailability(availability);
		if(list!=null) {
			responsestructure.setMessage("rooms found succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(list);
			return new ResponseEntity<Responsestructure<List<Room>>>(responsestructure,HttpStatus.FOUND);
			
		}else {
			return null;
		}
		
	}
	public ResponseEntity<Responsestructure<List<Room>>> getallrooms() {
		Responsestructure<List<Room>> responsestructure=new Responsestructure<>();
		List<Room> list=roomdao.getallrooms();
		if(list!=null) {
			responsestructure.setMessage("rooms found succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(list);
			return new ResponseEntity<Responsestructure<List<Room>>>(responsestructure,HttpStatus.FOUND);
		}else {
			return null;
		}
	}

	
	
}
