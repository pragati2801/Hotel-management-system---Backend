package com.jsp.hotelmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hotelmanagementsystem.dao.Bookingdao;
import com.jsp.hotelmanagementsystem.dao.Hoteldao;
import com.jsp.hotelmanagementsystem.dto.Hotel;
import com.jsp.hotelmanagementsystem.exception.Idnotfound;
import com.jsp.hotelmanagementsystem.util.Responsestructure;

@Service
public class Hotelservice {
	@Autowired
	private Hoteldao hoteldao;
	
	@Autowired
	private Bookingdao bookingdao;
	
	public ResponseEntity<Responsestructure<Hotel>> savehotel(Hotel hotel) {
		Responsestructure<Hotel> responsestructure=new Responsestructure<>();
		responsestructure.setMessage("succesfully saved");
		responsestructure.setStatus(HttpStatus.CREATED.value());
		responsestructure.setData(hoteldao.saveHotel(hotel));
		return new ResponseEntity<Responsestructure<Hotel>>(responsestructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<Responsestructure<Hotel>> updatehotel(int hid,Hotel hotel) {
		Responsestructure<Hotel> responsestructure=new Responsestructure<>();
		Hotel hotel2=hoteldao.gethotelbyid(hid);
		if(hotel2!=null) {
			hotel.setHotelid(hid);
			responsestructure.setMessage("succesfully updated");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(hoteldao.updateHotel(hotel));
			return new ResponseEntity<Responsestructure<Hotel>>(responsestructure,HttpStatus.OK);
		}
		else {
			throw new Idnotfound();
		}
	}
	
	public ResponseEntity<Responsestructure<Hotel>> deletehotel(int id) {
		Responsestructure<Hotel> responsestructure=new Responsestructure<>();
		Hotel hotel=hoteldao.gethotelbyid(id);
		if(hotel!=null) {
			responsestructure.setMessage("deleted succesfuly");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(hoteldao.deleteHotel(id));
			return new ResponseEntity<Responsestructure<Hotel>>(responsestructure,HttpStatus.OK);
		}else {
			throw new Idnotfound();
		}
	}
	
	public ResponseEntity<Responsestructure<Hotel>> gethotelbyid(int id) {
		Responsestructure<Hotel> responsestructure=new Responsestructure<>();
		Hotel hotel=hoteldao.gethotelbyid(id);
		if(hotel!=null) {
			responsestructure.setMessage("found succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(hotel);
			return new ResponseEntity<Responsestructure<Hotel>>(responsestructure,HttpStatus.FOUND);
		}else {
			throw new Idnotfound();
		}
	}
	
}
