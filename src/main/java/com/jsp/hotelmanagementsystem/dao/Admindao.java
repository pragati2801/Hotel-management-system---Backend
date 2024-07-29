package com.jsp.hotelmanagementsystem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jsp.hotelmanagementsystem.dto.Admin;
import com.jsp.hotelmanagementsystem.repo.Adminrepo;

@Repository
public class Admindao {
	
	private Adminrepo adminrepo;
	
	public Admin saveAdmin(Admin admin) {
		return adminrepo.save(admin);
		
	}
	
	public Admin updateAdmin(Admin admin) {
		return adminrepo.save(admin);
		
	}
	public Admin deleteAdmin(Admin admin) {
		adminrepo.delete(admin);
		return admin;
	
	}
	public Admin getadminbyid(int id) {
		if(adminrepo.findById(id).isPresent())
		{
			return adminrepo.findById(id).get();
		}
		else {
			return null;
		}
		
	}
	public List<Admin> getalladAdmin()
	{
		return adminrepo.findAll();
	}
	public Admin getadminbyemail(String adminemail) {
		return adminrepo.getadminbyemail(adminemail);
		
	}

}
