package com.jsp.hotelmanagementsystem.controller;

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

import com.jsp.hotelmanagementsystem.dto.Hotel;
import com.jsp.hotelmanagementsystem.service.Hotelservice;
import com.jsp.hotelmanagementsystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotel")
public class Hotelcontroller {
	
	@Autowired
	private Hotelservice hotelservice;
	
	@ApiOperation(value = "save hotel",notes = "api is used to save hotel data")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "succesfully saved"),@ApiResponse(code = 404,
	message = "hotel not saved give proper input")})
	@PostMapping
	public ResponseEntity<Responsestructure<Hotel>> savehotel(@RequestBody Hotel hotel) {
		return hotelservice.savehotel(hotel);
	}
	
	@ApiOperation(value = "update hotel",notes = "api is used to update hotel data")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully updated"),@ApiResponse(code = 404,
	message = "hotel not updated give proper input")})
	@PutMapping
	public ResponseEntity<Responsestructure<Hotel>> updatehotel(@RequestParam int hid,@RequestBody Hotel hotel){
		return hotelservice.updatehotel(hid, hotel);
	}
	
	@ApiOperation(value = "delete hotel",notes = "api is used to delete hotel data")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "succesfully deleted"),@ApiResponse(code = 404,
	message = "hotel not deleted give proper input")})
	@DeleteMapping
	public ResponseEntity<Responsestructure<Hotel>> deletehotel(@RequestParam int hid){
		return hotelservice.deletehotel(hid);
	}
	
	@ApiOperation(value = "get hotel by id",notes = "api is used to find hotel data")
	@ApiResponses(value = {@ApiResponse(code = 302,message = "succesfully found"),@ApiResponse(code = 404,
	message = "hotel not found give proper input")})
	@GetMapping
	public ResponseEntity<Responsestructure<Hotel>> gethotelbyid(@RequestParam int hid){
		return hotelservice.gethotelbyid(hid);
	}
	

}
