package com.anchtun.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User4 {

	private String name = "Anchtun";
	private Product2 product;
	
	public User4() {
		System.out.println("User4 bean created by Spring using default constructor");
	}
	
	@Autowired//from Spring 4.3 when we have only one constructor @Autowired annotation will be optional 
	public User4(Product2 product) {
		System.out.println("User4 bean created by Spring using parameterized constructor");
		this.product = product;
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

	public void setProduct(Product2 product) {
		this.product = product;
	}

}
