package com.jsp.hotelmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.hotelmanagementsystem.dto.Admin;

public interface Adminrepo extends JpaRepository<Admin, Integer>{
	
	@Query ("select a from Admin a where a.adminemail=?1")
	public Admin getadminbyemail(String adminemail); 
		
	

}
