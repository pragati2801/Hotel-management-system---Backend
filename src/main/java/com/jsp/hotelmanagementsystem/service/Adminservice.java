package com.jsp.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hotelmanagementsystem.dao.Admindao;
import com.jsp.hotelmanagementsystem.dao.Bookingdao;
import com.jsp.hotelmanagementsystem.dao.Hoteldao;
import com.jsp.hotelmanagementsystem.dto.Admin;
import com.jsp.hotelmanagementsystem.dto.Hotel;
import com.jsp.hotelmanagementsystem.util.Responsestructure;

@Service
public class Adminservice {
	
	@Autowired
	private Admindao admindao;
	
	@Autowired
	private Hoteldao hoteldao;
	
	@Autowired
	private Bookingdao bookingdao;
	
	Responsestructure<Admin> responsestructure= new Responsestructure<>();
	
	public ResponseEntity<Responsestructure<Admin>> saveadmin(Admin admin,int hid) {
		Hotel hotel=hoteldao.gethotelbyid(hid);
		admin.setHotel(hotel);
		Admin admin2=admindao.saveAdmin(admin);
		if(admin2!=null) {
			responsestructure.setMessage("admin saved succesfully");
			responsestructure.setStatus(HttpStatus.CREATED.value());
			responsestructure.setData(admin2);
		}
		return new ResponseEntity<Responsestructure<Admin>>(responsestructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<Responsestructure<Admin>> updateadmin(Admin admin,int aid) {
		Admin admin2= admindao.getadminbyid(aid);
		admin2.setHotel(admin2.getHotel());
		if(admin2 != null)
		{
			responsestructure.setMessage("admin updated succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(admin);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure,HttpStatus.OK);
			
		}
		else {
			return null;
		}

	}

	public ResponseEntity<Responsestructure<Admin>> deleteadmin(int aid) {
		Admin admin= admindao.getadminbyid(aid);
		if(admin != null)
		{
			responsestructure.setMessage("admin deleted succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(admindao.deleteAdmin(admin));
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure,HttpStatus.OK);
			
		}
		else {
			return null;
		}
	}

	public ResponseEntity<Responsestructure<Admin>> getadminbyid(int id) {
		Admin admin= admindao.getadminbyid(id);
		if(admin != null)
		{
			responsestructure.setMessage("admin found succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(admin);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure,HttpStatus.FOUND);
			
		}
		else {
			return null;
		}
	}
	public ResponseEntity<Responsestructure<Admin>> getadminbyemail(String email) {
		Admin admin= admindao.getadminbyemail(email);
		if(admin != null)
		{
			responsestructure.setMessage("admin found succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(admin);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure,HttpStatus.FOUND);
			
		}
		else {
			return null;
		}
	}
	
	public ResponseEntity<Responsestructure<List<Admin>>> getalladmin() {
		
		Responsestructure<List<Admin>> responsestructure= new Responsestructure<>();
		if(admindao.getalladAdmin()!= null)
		{
			responsestructure.setMessage("admin found succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(admindao.getalladAdmin());
			return new ResponseEntity<Responsestructure<List<Admin>>>(responsestructure,HttpStatus.FOUND);
			
		}
		else {
			return null;
		}
	}
	public ResponseEntity<Responsestructure<Admin>> loginadmin(String email,String password) {
		Admin admin=admindao.getadminbyemail(email);
		if(admin.getAdminpassword().equals(password)) {
			responsestructure.setMessage("admin loggedin succefully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(admin);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure,HttpStatus.OK);
		}else {
			responsestructure.setMessage("enter valid email and password");
			responsestructure.setStatus(HttpStatus.BAD_REQUEST.value());
			responsestructure.setData(null);
			return new ResponseEntity<Responsestructure<Admin>>(responsestructure,HttpStatus.BAD_REQUEST);
		}
	}
	
	
	

}
