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

import com.jsp.hotelmanagementsystem.dto.Booking;
import com.jsp.hotelmanagementsystem.service.Bookingservice;
import com.jsp.hotelmanagementsystem.util.Responsestructure;

@RestController
@RequestMapping
public class Bookingcontroller {
	
	@Autowired
	private Bookingservice bookingservice;
	
	@PostMapping
	public ResponseEntity<Responsestructure<Booking>> savebooking(@RequestBody Booking booking,@RequestParam int cid,@RequestParam int rid) {
		return bookingservice.savebooking(booking, cid, rid);
		
	}
	
	@PutMapping
	public ResponseEntity<Responsestructure<Booking>> updatebooking(@RequestBody Booking booking,@RequestParam int bid){
		return bookingservice.updatebooking(bid, booking);
	}
	
	@DeleteMapping
	public ResponseEntity<Responsestructure<Booking>> deletebooking(@RequestParam int bid){
		return bookingservice.deletebooking(bid);
	}
	
	@GetMapping
	public ResponseEntity<Responsestructure<Booking>> getbookingbyid(@RequestParam int bid){
		return bookingservice.getbookingbyid(bid);
	}
	
	@GetMapping("/getallbooking")
	public ResponseEntity<Responsestructure<List<Booking>>> getallbooking(){
		return bookingservice.getallbookings();
	}
	
	@PutMapping("/closebooking")
	public ResponseEntity<Responsestructure<Booking>> closebooking(@RequestParam int bid){
		return bookingservice.closebooking(bid);
	}

}
