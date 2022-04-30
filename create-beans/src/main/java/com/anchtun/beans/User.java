package com.anchtun.beans;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String name;

	public void sayHello() {
		System.out.println("Hello from Component User bean");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
