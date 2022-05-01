package com.anchtun.beans;

import org.springframework.stereotype.Component;

@Component
public class Product2 {
	
	private String name = "Laptop Lenovo";
	
	public Product2() {
		System.out.println("Product bean created by Spring");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
