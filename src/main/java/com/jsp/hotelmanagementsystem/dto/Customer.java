package com.jsp.hotelmanagementsystem.dto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerid;
	@NotBlank(message = "customer cannot be null or blank")
	private String customername;
	@NotBlank(message = "customer address cannot be null or blank")
	private String customeraddress;
	@NotBlank(message = "email cannot be null or blank")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "Invalid Email")
	private String customeremail;
	@NotBlank(message = "password cannot be null or blank")
	@Pattern(regexp = "^(?=.*[0-9])+(?=.*[a-z])+(?=.*[A-Z])+(?=.*[@#$%^&+=])+(?=\\S+$).{6,}$", message = "min 6 characters mandatory(1 upperCase,1 lowerCase,1 specialCharacter,1 number)")
	private String customerpassword;
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long customerphone;
	@NotBlank(message = "customer aadhar cannot be null or blank")
	@Pattern(regexp = "[1-9][1-9]{11}", message = "Invalid Aadhar")//shd give 12 numbers
	private String customeradhar;

}
