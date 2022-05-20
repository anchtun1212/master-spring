package com.anchtun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
/**
 * By Default spring data jpa uses Hibernate as an implementation of JPA specification
 */

@Data
@Entity
@Table(name = "contact_msg")
public class Contact extends BaseEntity {

	@Id
	@Column(name = "contact_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contactId;

	@NotBlank(message = "Name must not be blank")
	@Size(min = 3, message = "Name must have at least 3 characters")
	@Column(name = "name")
	private String fullName2;
	
	@NotBlank(message = "Mobile must not be blank")
	@Pattern(regexp = "^([+]\\d{2})?\\d{10}$", message = "Mobile should be like this: Ex: +966123456789 or 0123456789")
	@Column(name = "mobile_num")
	private String mobile2;
	
	@NotBlank(message = "Subject must not be blank")
	@Size(min = 7, message = "Subject must have at least 7 characters")
	@Column(name = "subject")
	private String subject2;
	
	@NotBlank(message = "Email must not be blank")
	@Email(message = "Please enter a valid email")
	@Column(name = "email")
	private String email2;
	
	// mean message open or close
	private String status;

	@Override
	public String toString() {
		return "Contact [fullName=" + fullName2 + ", email=" + email2 + ", mobile=" + mobile2 + ", subject=" + subject2 + "]";
	}
}
