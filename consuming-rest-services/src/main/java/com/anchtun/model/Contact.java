package com.anchtun.model;

import lombok.Data;

@Data
public class Contact {

	private int contactId;

	private String name;

	private String mobile;

	private String subject;

	private String email;

	private String status;

	public String toString() {
		return "Contact [fullName=" + name + ", email=" + email + ", mobile=" + mobile + ", subject=" + subject + "]";
	}
}
