package com.jsp.hotelmanagementsystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.hotelmanagementsystem.dto.Customer;
import com.jsp.hotelmanagementsystem.repo.Customerrepo;

@Repository
public class Customerdao {
	
	@Autowired
	private Customerrepo customerrepo;
	
	public Customer saveCustomer(Customer customer) {
		return customerrepo.save(customer);
		
	}
	
	public Customer updateCustomer(Customer customer) {
		return customerrepo.save(customer);
		
	}
	public Customer deleteCustomer(Customer customer) {
		 customerrepo.delete(customer);
		 return customer;
		
	}
	
	public Customer getcustomerbyid(int id) {
		if(customerrepo.findById(id).isPresent())
		{
			return customerrepo.findById(id).get();
		}
		
		else {
			return null;
		}
		
	}
	
	public List<Customer> getallcustomer() {
		return customerrepo.findAll();
		
	}
	
	public Customer getcustomerbyemail(String email) {
		return customerrepo.getcustomerbyemail(email);
	}

}
