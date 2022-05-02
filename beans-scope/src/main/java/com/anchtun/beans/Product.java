package com.anchtun.beans;

import org.springframework.stereotype.Component;

@Component
public class Product {

	private String name;

	public Product() {
		System.out.println("Product bean created by Spring");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
