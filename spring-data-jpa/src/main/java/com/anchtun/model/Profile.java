package com.anchtun.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;

@Builder
// we can use Person an Address classes but for more readability we create this Class
// simple Model class that help us to bring the data from UI to the backend and vice versa
@Data
public class Profile {
	
	@NotBlank(message = "Name must not be blank")
	@Size(min = 3, message = "Name must have at least 3 characters")
	private String name;
	
	@NotBlank(message = "Mobile must not be blank")
	@Pattern(regexp = "^([+]\\d{2})?\\d{10}$", message = "Mobile should be like this: Ex: +966123456789 or 0123456789")
	private String mobileNumber;
	
	
	@NotBlank(message = "Email must not be blank")
	@Email(message = "Please enter a valid email")
	private String email;
	
	@NotBlank(message = "Address1 must not be blank")
	@Size(min = 5, message = "Address1 must have at least 5 characters")
	private String address1;

	private String address2;

	@NotBlank(message = "City must not be blank")
	@Size(min = 3, message = "City must have at least 3 characters")
	private String city;

	@NotBlank(message = "State must not be blank")
	@Size(min = 3, message = "State must have at least 3 characters")
	private String state;

	@NotBlank(message = "Zip Code must not be blank")
	@Pattern(regexp = "^$|[0-9]{5}", message = "Zip Code must be 5 digits")
	private String zipCode;

}
