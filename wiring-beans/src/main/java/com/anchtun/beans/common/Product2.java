package com.anchtun.beans.common;

import org.springframework.stereotype.Component;

@Component
public class Product2 {
	
	private String name = "Laptop Lenovo";
	
	public Product2() {
		System.out.println("Product2 bean created by Spring");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
