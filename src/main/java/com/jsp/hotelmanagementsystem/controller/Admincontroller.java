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

import com.jsp.hotelmanagementsystem.dto.Admin;
import com.jsp.hotelmanagementsystem.service.Adminservice;
import com.jsp.hotelmanagementsystem.util.Responsestructure;


@RestController
@RequestMapping("/admin")
public class Admincontroller {
	
	@Autowired
	private Adminservice adminservice;
	
	@PostMapping
	public ResponseEntity<Responsestructure<Admin>> saveadmin(@RequestBody Admin admin,@RequestParam int hid){
		return adminservice.saveadmin(admin, hid);
	}
	
	@PutMapping
	public ResponseEntity<Responsestructure<Admin>> updateadmin(@RequestParam int aid,@RequestBody Admin admin){
		return adminservice.updateadmin(admin, aid);
		
	}
	
	@DeleteMapping
	public ResponseEntity<Responsestructure<Admin>> deleteadmin(@RequestParam int aid){
		return adminservice.deleteadmin(aid);
	}
	
	@GetMapping
	public ResponseEntity<Responsestructure<Admin>> getadminbyid(@RequestParam int aid){
		return adminservice.getadminbyid(aid);
	}
	
	@GetMapping("/adminbyemail")
	public ResponseEntity<Responsestructure<Admin>> getadminbyemail(@RequestParam String email){
		return adminservice.getadminbyemail(email);
	}
	
	@GetMapping("/getalladmin")
	public ResponseEntity<Responsestructure<List<Admin>>> getalladmin(){
		return adminservice.getalladmin();
	}
	
	@GetMapping("/adminlogin")
	public ResponseEntity<Responsestructure<Admin>> loginadmin(@RequestParam String email,@RequestParam String password){
		return adminservice.loginadmin(email, password);
	}
	
	

}
