package com.anchtun.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User3 {

	private String name = "Anchtun";
	private Product2 product;
	
	public User3() {
		System.out.println("User bean created by Spring");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product2 getProduct() {
		return product;
	}

	@Autowired
	public void setProduct(Product2 product) {
		this.product = product;
	}

}
