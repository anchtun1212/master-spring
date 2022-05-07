package com.anchtun.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 
 * add @Data lombok annotation
 * @Data combines those lombok annotations (@Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor)
 *
 */
@Data
public class Contact {

	/**
	 * Bean validation
	 * @NotNull: checks if a given field is not null but allows empty values & zero elements inside collections.
	 * @NotEmpty: checks if a given field is not null & its size/length is greater than zero.
	 * @NotBlank: checks if a given field is not null & trimmed (trim) length is greater than zero.
	 */
	@NotBlank(message = "Name must not be blank")
	@Size(min = 3, message = "Name must have at least 3 characters")
	private String fullName2;
	
	@NotBlank(message = "Mobile must not be blank")
	@Pattern(regexp = "^([+]\\d{2})?\\d{10}$", message = "Mobile should be like this: Ex: +966123456789 or 0123456789")
	private String mobile2;
	
	@NotBlank(message = "Subject must not be blank")
	@Size(min = 7, message = "Subject must have at least 7 characters")
	private String subject2;
	
	@NotBlank(message = "Email must not be blank")
	@Email(message = "Please enter a valid email")
	private String email2;

	/**
	 * lombok @Data by default generate toString, but we need to override it
	 */
	@Override
	public String toString() {
		return "Contact [fullName=" + fullName2 + ", email=" + email2 + ", mobile=" + mobile2 + ", subject=" + subject2 + "]";
	}
}
