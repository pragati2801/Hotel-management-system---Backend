package com.jsp.hotelmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.hotelmanagementsystem.dto.Room;
import com.jsp.hotelmanagementsystem.service.Roomservice;
import com.jsp.hotelmanagementsystem.util.Responsestructure;


@RestController
@RequestMapping("/room")
public class Roomcontroller {
	@Autowired
	private Roomservice roomservice;
	
	@PostMapping
	public ResponseEntity<Responsestructure<Room>> saveroom(@RequestBody Room room,@RequestParam int hid) {
		return roomservice.saveRoom(room, hid);
		
	}
	
	@PutMapping
	public ResponseEntity<Responsestructure<Room>> updateroom(@RequestParam int rid,@RequestBody Room room){
		return roomservice.updateroom(room, rid);
	}
	
	@DeleteMapping
	public ResponseEntity<Responsestructure<Room>> deleteroom(@RequestParam int rid){
		return roomservice.deleteroom(rid);
	}
	
	@GetMapping
	public ResponseEntity<Responsestructure<Room>> getroombyid(@RequestParam int rid){
		return roomservice.getroombyid(rid);
	}
	
	@GetMapping("/getallroom")
	public ResponseEntity<Responsestructure<List<Room>>> getallroom(){
		return roomservice.getallrooms();
	}
	
	@GetMapping("/roombytype")
	public ResponseEntity<Responsestructure<List<Room>>> getroombytype(@RequestParam String roomtype){
		return roomservice.getroombytype(roomtype);
	}
	
	@GetMapping("/roombyno")
	public ResponseEntity<Responsestructure<Room>> getroombyno(@RequestParam String roomno){
		return roomservice.getroombyno(roomno);
	}
	
	@GetMapping("/roombyavailability")
	public ResponseEntity<Responsestructure<List<Room>>> getroombyavailability(@RequestParam String availability){
		return roomservice.getroombyavailability(availability);
	}

}
