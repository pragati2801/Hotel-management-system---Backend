package com.jsp.hotelmanagementsystem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotelmanagementsystem.dto.Hotel;
import com.jsp.hotelmanagementsystem.repo.Hotelrepo;

@Repository
public class Hoteldao {
	@Autowired
	private Hotelrepo hotelrepo;
	
	public Hotel saveHotel(Hotel hotel) {
		return hotelrepo.save(hotel);	
		
	}
	
	public Hotel updateHotel(Hotel hotel) {
		return hotelrepo.save(hotel);
		
	}
	public Hotel deleteHotel(int id) {
		if(hotelrepo.findById(id).isPresent())
		{
			Hotel hotel=hotelrepo.findById(id).get();
			hotelrepo.delete(hotel);
			return hotel;
			
		}
		else {
			return null;	
		}
			
	}
	public Hotel gethotelbyid(int id) {
		if (hotelrepo.findById(id).isPresent()) {
			return hotelrepo.findById(id).get();
		} else {
			return null;
		}
	}

}
