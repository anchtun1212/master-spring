package com.anchtun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Address extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;

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
	@Column(name = "zip_code")
	private String zipCode;
}
