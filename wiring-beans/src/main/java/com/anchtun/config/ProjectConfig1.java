package com.anchtun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anchtun.beans.Product;
import com.anchtun.beans.User;

@Configuration
public class ProjectConfig1 {

	/**
	 * wiring beans using method call
	 */

	@Bean
	public Product latopLenovo() {
		var product = new Product();
		product.setName("Laptop Lenovo");
		return product;
	}

	@Bean
	public User user() {
		var user = new User();
		user.setName("Anchtun");
		user.setProduct(latopLenovo());
		return user;
	}
}
