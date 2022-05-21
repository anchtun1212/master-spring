package com.anchtun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.anchtun.annotation.FieldsValueMatch;
import com.anchtun.annotation.PasswordValidator;

import lombok.Data;

@Data
@Entity
@FieldsValueMatch.List({
	@FieldsValueMatch(
			field = "password",
			fieldMatch = "confirmPassword",
			message = "Passwords do not match"
			),
	@FieldsValueMatch(
			field = "email",
			fieldMatch = "confirmEmail",
			message = "Emails do not match"
			)
})
public class Person {

	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;
	
	@NotBlank(message = "Name must not be blank")
	@Size(min = 3, message = "Name must have at least 3 characters")
	private String name;
	
	@NotBlank(message = "Mobile must not be blank")
	@Pattern(regexp = "^([+]\\d{2})?\\d{10}$", message = "Mobile should be like this: Ex: +966123456789 or 0123456789")
	@Column(name = "mobile_num")
	private String mobileNumber;
	
	
	@NotBlank(message = "Email must not be blank")
	@Email(message = "Please enter a valid email")
	private String email;
	
	@NotBlank(message = "Confirm email must not be blank")
	@Email(message = "Please enter a valid confirm email")
	// to tell spring data jpa to not use this field for all DB operations
	@Transient
	private String confirmEmail;
	
	@NotBlank(message = "Password must not be blank")
	@Size(min = 5, message = "Password must have at least 5 characters")
	@PasswordValidator
	private String password;
	
	@NotBlank(message = "Confirm password must not be blank")
	@Size(min = 5, message = "Confirm password must have at least 5 characters")
	// to tell spring data jpa to not use this field for all DB operations
	@Transient
	private String confirmPassword;
}
