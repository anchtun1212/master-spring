package com.anchtun.beans.test7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class User7 {

	private String name = "Anchtun";
	private Product7 product;
	
	public User7() {
		System.out.println("User7 bean created by Spring");
	}
	
	@Autowired
	public User7(@Qualifier("product1") Product7 product) {
		System.out.println("User7 bean created by Spring");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Product7 getProduct() {
		return product;
	}
	
	public void setProduct(Product7 product) {
		this.product = product;
	}
	
	
}
