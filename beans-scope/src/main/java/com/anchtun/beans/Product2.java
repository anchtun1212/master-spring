package com.anchtun.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Product2 {

	private String name;

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
