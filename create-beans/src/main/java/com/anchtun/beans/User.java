package com.anchtun.beans;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void helloHello() {
		System.out.println("Hello from Component User bean");
	}
}
