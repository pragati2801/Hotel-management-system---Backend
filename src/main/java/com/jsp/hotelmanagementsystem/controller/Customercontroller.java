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

import com.jsp.hotelmanagementsystem.dto.Customer;
import com.jsp.hotelmanagementsystem.service.Customerservice;
import com.jsp.hotelmanagementsystem.util.Responsestructure;

@RestController
@RequestMapping("/customer")
public class Customercontroller {
	@Autowired
	private Customerservice customerservice;
	
	@PostMapping
	public ResponseEntity<Responsestructure<Customer>> savecustomer(@RequestBody Customer customer) {
		return customerservice.savecustomer(customer);
		
	}
	
	@PutMapping
	public ResponseEntity<Responsestructure<Customer>> updatecustomer(@RequestParam int cid,@RequestBody Customer customer){
		return customerservice.updatecustomer(cid, customer);
	}
	
	@DeleteMapping
	public ResponseEntity<Responsestructure<Customer>> deletecustomer(@RequestParam int cid){
		return customerservice.deletecustomer(cid);
	}
	@GetMapping
	public ResponseEntity<Responsestructure<Customer>> getcustometbyid(@RequestParam int cid){
		return customerservice.getcustomerbyid(cid);
	}
	
	@GetMapping("/getallcustomer")
	public ResponseEntity<Responsestructure<List<Customer>>> getallcustomer(){
		return customerservice.getallcustomer();
	}
	
	@GetMapping("/getcustomerbyemail")
	public ResponseEntity<Responsestructure<Customer>> getcustomerbyemail(@RequestParam String email){
		return customerservice.getcustomerbyemail(email);
	}
	
	@GetMapping("/logincustomer")
	public ResponseEntity<Responsestructure<Customer>> logincustomer(@RequestParam String email,@RequestParam String password){
		return customerservice.logincustomer(email, password);
	}
	
	

}
