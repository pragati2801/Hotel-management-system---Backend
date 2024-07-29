package com.jsp.hotelmanagementsystem.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomid;
	@NotBlank(message = "room no cannot be null or blank")
	private String roomno;
	@NotBlank(message = "room type cannot be null or blank")
	private String roomtype;
	@NotBlank(message = "room price cannot be null or blank")
	private String roomprice;
	@Min(value = 1)
	@Max(value = 10)
	private int noofbeds;
	@Min(value = 1)
	@Max(value = 10)
	private int maxnoofpeople;
	@NotBlank(message = "availability should not be blank or null")
	@Pattern(regexp = "[Y,N]")
	private String availability;
	
	@Enumerated
	private Floor floor;
	
	@ManyToOne
	private Hotel hotel;

	
	
	
	
	

}
