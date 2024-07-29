package com.jsp.hotelmanagementsystem.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotelmanagementsystem.dto.Booking;

import com.jsp.hotelmanagementsystem.repo.Bookingrepo;

@Repository
public class Bookingdao {
	
	@Autowired
	private Bookingrepo bookingrepo;
	
	public Booking saveBooking(Booking booking) {
		return bookingrepo.save(booking);
		
	}
	
	public Booking updatebooking(Booking booking) {
		return bookingrepo.save(booking);
		
	}
	
	public Booking deletebooking(Booking booking) {
		 bookingrepo.delete(booking);
		 return booking;
		
	}
	
	public Booking getBookingbyid(int id) {
		if(bookingrepo.findById(id).isPresent())
		{
			return bookingrepo.findById(id).get();
		}
		else {
			return null;
		}
		
	}
	
	public List<Booking> getallbookings() {
		return bookingrepo.findAll();
	}
	public Booking getbookingbycheckin(String check_in_date) {
		return bookingrepo.getbookingbycheckin(check_in_date);
	}
	public Booking getbookingbycheckout(String check_out_date) {
		return bookingrepo.getbookingbycheckout(check_out_date);
	}

}
