package com.jsp.hotelmanagementsystem.dto;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Hotel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hotelid;
	@NotBlank(message = "hotel name cannot be null or blank")
	private String hotelname;
	@NotBlank(message = "hotel gst cannot be null or blank")
	private String hotelgst;
	@NotBlank(message = "hotel address cannot be null or blank")
	private String hoteladdress;
	@NotBlank(message = "hotel owner cannot be null or blank")
	private String hotelowner;
	@NotBlank(message = "hotel manager cannot be null or blank")
	private String hotelmanager;
	@Min(value = 1)
	@Max(value = 5)
	private int hotelrating;
	
	

}
