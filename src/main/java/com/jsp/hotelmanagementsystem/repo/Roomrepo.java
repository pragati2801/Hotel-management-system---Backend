package com.jsp.hotelmanagementsystem.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.hotelmanagementsystem.dto.Room;

public interface Roomrepo extends JpaRepository<Room, Integer> {
	
	@Query("Select r from Room r.room_type=?1")
	public List<Room> getroombytype(String room_type);
	
	@Query("select r from Room r where r.roomno=?1")
	public Room getroombyno(String roomno);
	
	@Query("select r from Room r where r.availability=?1")
	public List<Room> getroombyavailability(String availability);

	

}
