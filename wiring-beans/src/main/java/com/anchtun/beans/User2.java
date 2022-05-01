package com.anchtun.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User2 {

	private String name = "Anchtun";
	
	/**
	 * Marks on field, constructor, setter method
	 * is used to auto-wire the beans that is 'injecting beans' (objects) at runtime
	 * by Spring Dependency Injection mechanism
	 */
	@Autowired
	private Product2 product;
	
	public User2() {
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

	public void setProduct(Product2 product) {
		this.product = product;
	}

}
