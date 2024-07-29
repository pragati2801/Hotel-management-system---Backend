package com.jsp.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.hotelmanagementsystem.dao.Customerdao;
import com.jsp.hotelmanagementsystem.dto.Customer;
import com.jsp.hotelmanagementsystem.dto.Room;
import com.jsp.hotelmanagementsystem.util.Responsestructure;

@Service
public class Customerservice {
	@Autowired
	private Customerdao customerdao;
	
	Responsestructure<Customer> responsestructure=new Responsestructure<>();
	
	public ResponseEntity<Responsestructure<Customer>> savecustomer(Customer customer)
	{
		Customer customer2=customerdao.saveCustomer(customer);
		if(customer2!=null) {
			responsestructure.setMessage("customer saved succesfully");
			responsestructure.setStatus(HttpStatus.CREATED.value());
			responsestructure.setData(customer2);
		}
		return new ResponseEntity<Responsestructure<Customer>>(responsestructure,HttpStatus.CREATED);
	
		
	}
	public ResponseEntity<Responsestructure<Customer>> updatecustomer(int cid ,Customer customer)
	{
		Customer customer2=customerdao.getcustomerbyid(cid);
		if(customer2!=null) {
			customer.setCustomerid(cid);
			responsestructure.setMessage("customer updated succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(customerdao.updateCustomer(customer));
			return new ResponseEntity<Responsestructure<Customer>>(responsestructure,HttpStatus.OK);
		}
		else {
			return null;
		}
		
		
	}
	
	public ResponseEntity<Responsestructure<Customer>> deletecustomer(int cid)
	{
		Customer customer=customerdao.getcustomerbyid(cid);
		if(customer!=null)
		{
			responsestructure.setMessage("customer deleted succesfully");
			responsestructure.setStatus(HttpStatus.OK.value());
			responsestructure.setData(customerdao.deleteCustomer(customer));
			return new ResponseEntity<Responsestructure<Customer>>(responsestructure,HttpStatus.OK);
		}
		else {
			return null;
		}
			
		}
	
	public ResponseEntity<Responsestructure<Customer>> getcustomerbyid(int cid)
	{
		Customer customer=customerdao.getcustomerbyid(cid);
		if(customer!=null)
		{
			responsestructure.setMessage("customer found succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(customer);
			return new ResponseEntity<Responsestructure<Customer>>(responsestructure,HttpStatus.FOUND);
		}
		else {
			return null;
		}
		
	}
	
	public ResponseEntity<Responsestructure<Customer>> getcustomerbyemail(String email)
	{
		Customer customer=customerdao.getcustomerbyemail(email);
		if(customer!=null)
		{
			responsestructure.setMessage("customer found succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(customer);
			return new ResponseEntity<Responsestructure<Customer>>(responsestructure,HttpStatus.FOUND);
		}
		else {
			return null;
		}
		
		
	}
	
	public ResponseEntity<Responsestructure<List<Customer>>> getallcustomer()
	{
		Responsestructure<List<Customer>> responsestructure=new Responsestructure<>();
		if(customerdao.getallcustomer()!=null)
		{
			responsestructure.setMessage("customer found succesfully");
			responsestructure.setStatus(HttpStatus.FOUND.value());
			responsestructure.setData(customerdao.getallcustomer());
			return new ResponseEntity<Responsestructure<List<Customer>>>(responsestructure,HttpStatus.FOUND);
			
		}
		else {
			return null;
		}
	}
	
		public ResponseEntity<Responsestructure<Customer>> logincustomer(String email , String password) {
			Customer customer=customerdao.getcustomerbyemail(email);
			if(customer.getCustomerpassword().equals(password)) {
				responsestructure.setMessage("customer loggedin succesfully");
				responsestructure.setStatus(HttpStatus.OK.value());
				responsestructure.setData(customer);
				return new ResponseEntity<Responsestructure<Customer>>(responsestructure,HttpStatus.OK);
				
			}else {
				responsestructure.setMessage("enter valid email and password");
				responsestructure.setStatus(HttpStatus.BAD_REQUEST.value());
				responsestructure.setData(null);
				return new ResponseEntity<Responsestructure<Customer>>(responsestructure,HttpStatus.BAD_REQUEST);
			}
		}
		
	

}
