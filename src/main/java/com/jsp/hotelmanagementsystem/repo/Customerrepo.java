package com.jsp.hotelmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.hotelmanagementsystem.dto.Customer;

public interface Customerrepo extends JpaRepository<Customer, Integer> {
	
	@Query("select c from Customer c where c.email=?1")
	public Customer getcustomerbyemail(String email) ;



}
