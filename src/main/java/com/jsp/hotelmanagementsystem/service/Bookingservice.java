package com.jsp.hotelmanagementsystem.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hotelmanagementsystem.dao.Bookingdao;
import com.jsp.hotelmanagementsystem.dao.Customerdao;
import com.jsp.hotelmanagementsystem.dao.Roomdao;
import com.jsp.hotelmanagementsystem.dto.Booking;
import com.jsp.hotelmanagementsystem.dto.Customer;
import com.jsp.hotelmanagementsystem.dto.Room;
import com.jsp.hotelmanagementsystem.exception.Idnotfound;
import com.jsp.hotelmanagementsystem.exception.Maxnumberofexception;
import com.jsp.hotelmanagementsystem.util.Responsestructure;

@Service
public class Bookingservice {
	@Autowired
	private Bookingdao bookingdao;
	
	@Autowired
	private Roomdao roomdao;
	
	@Autowired
	private Customerdao customerdao;
	Responsestructure<Booking> responsestructure=new Responsestructure<>();
	
	public ResponseEntity<Responsestructure<Booking>> savebooking(Booking booking,int cid,int rid) {
		Room room=roomdao.getroombyid(rid);
		room.setAvailability("N");
		if(booking.getNo_of_people()<=room.getMaxnoofpeople()) {
			Room room2=roomdao.saveRoom(room);
			Customer customer=customerdao.getcustomerbyid(cid);
			booking.setCustomer(customer);
			booking.setRoom(room2);
			LocalDateTime dateTime=LocalDateTime.now();
			booking.setCheck_in_date(dateTime);
			responsestructure.setMessage("booking saved successfully");
			responsestructure.setStatus(HttpStatus.CREATED.value());
			responsestructure.setData(bookingdao.saveBooking(booking));
			return new ResponseEntity<Responsestructure<Booking>>(responsestructure,HttpStatus.CREATED);
		}
		else {
			return null;
		}
		
	}
	public ResponseEntity<Responsestructure<Booking>> updatebooking(int bid,Booking booking) {
		Booking booking2=bookingdao.getBookingbyid(bid);
		if(booking2!=null) {
			if(booking.getNo_of_people()<=booking2.getRoom().getMaxnoofpeople()) {
				booking.setId(bid);
				booking.setCustomer(booking2.getCustomer());
				booking.setRoom(booking2.getRoom());
				booking.setCheck_in_date(booking2.getCheck_in_date());
				booking.setCheck_out_date(booking2.getCheck_out_date());
				responsestructure.setMessage("booking updated succesfully");
				responsestructure.setStatus(HttpStatus.OK.value());
				responsestructure.setData(bookingdao.updatebooking(booking));
				return new ResponseEntity<Responsestructure<Booking>>(responsestructure,HttpStatus.OK);
			}else {
				throw new Maxnumberofexception();
			}
		}else {
			throw new Idnotfound();
		}
		
	}
	public ResponseEntity<Responsestructure<Booking>> deletebooking(int bid)
	{
		Booking booking=bookingdao.getBookingbyid(bid);
		if(booking!=null)
		{
			responsestructure.setMessage("booking deleted succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(bookingdao.deletebooking(booking));
			return new ResponseEntity<Responsestructure<Booking>>(responsestructure,HttpStatus.OK);
		}
		else {
			return null;
		}
		
	}
	
	public ResponseEntity<Responsestructure<Booking>> getbookingbyid(int bid) {
		Booking booking=bookingdao.getBookingbyid(bid);
		if(booking!=null) {
			responsestructure.setMessage("booking found succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(booking);
			return new ResponseEntity<Responsestructure<Booking>>(responsestructure,HttpStatus.FOUND);
		}else {
			return null;
		}
	}
	
	public ResponseEntity<Responsestructure<List<Booking>>> getallbookings() {
		Responsestructure<List<Booking>> responsestructure=new Responsestructure<>();
		if(bookingdao.getallbookings()!=null) {
			responsestructure.setMessage("bookings found succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(bookingdao.getallbookings());
			return new ResponseEntity<Responsestructure<List<Booking>>>(responsestructure,HttpStatus.FOUND);
		}else {
			return null;
		}
	}
	
	public ResponseEntity<Responsestructure<Booking>> closebooking(int bid) {
		Booking booking=bookingdao.getBookingbyid(bid);
		if(booking!=null) {
			LocalDateTime checkouttime=LocalDateTime.now();
			booking.setCheck_out_date(checkouttime);
			Room room=booking.getRoom();
			room.setAvailability("Y");
			booking.setRoom(room);
			responsestructure.setMessage("succesfylly closed the booking");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(bookingdao.updatebooking(booking));
			return new ResponseEntity<Responsestructure<Booking>>(responsestructure,HttpStatus.OK);
		}else {
			throw new Maxnumberofexception();
		}
			
	}

}
