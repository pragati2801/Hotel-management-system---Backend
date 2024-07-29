package com.jsp.hotelmanagementsystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.hotelmanagementsystem.dto.Hotel;

public interface Hotelrepo extends JpaRepository<Hotel, Integer> {

}
