package com.anchtun.beans.test7;

import org.springframework.beans.factory.annotation.Autowired;

public class Product7 {

	private String name;
	
	@Autowired
	private User7 user;

	public Product7() {
		System.out.println("Product7 bean created by Spring");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User7 getUser() {
		return user;
	}

	public void setUser(User7 user) {
		this.user = user;
	}
	
}
