package com.anchtun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anchtun.beans.Product;

@Configuration
public class ProjectConfig2 {

	/**
	 * 
	 * multiple objects with same types
	 */
	@Bean
	Product product1() {
		var prod = new Product();
		prod.setName("Laptop Sony vaio");
		return prod;
	}

	@Bean
	Product product2() {
		var prod = new Product();
		prod.setName("Laptop Dell");
		return prod;
	}

}
