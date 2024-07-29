package com.jsp.hotelmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.hotelmanagementsystem.dto.Booking;

public interface Bookingrepo extends JpaRepository<Booking, Integer> {
	
	@Query("select b from Booking b where b.check_in_date=?1")
	public Booking getbookingbycheckin(String check_in_date) ;
	
	@Query("select b from Booking b where b.check_out_date=?1")
	public Booking getbookingbycheckout(String check_out_date) ;

}
