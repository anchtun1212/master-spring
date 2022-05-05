package com.anchtun.model;

public class Contact {

	private String fullName2;
	private String mobile2;
	private String subject2;
	
	public String getFullName2() {
		return fullName2;
	}
	public void setFullName2(String fullName2) {
		this.fullName2 = fullName2;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	public String getSubject2() {
		return subject2;
	}
	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}
	@Override
	public String toString() {
		return "Contact [fullName=" + fullName2 + ", mobile=" + mobile2 + ", subject=" + subject2 + "]";
	}
}
