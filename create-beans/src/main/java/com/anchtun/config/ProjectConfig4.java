package com.anchtun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.anchtun.beans.Product;

@Configuration
public class ProjectConfig4 {

	/**
	 * 
	 * multiple objects with same types
	 * name a bean 
	 * USE @Primary annotation
	 */
	// name parameter
	@Bean(name = "laptopSonyVaio")
	Product product1() {
		var prod = new Product();
		prod.setName("Sony vaio");
		return prod;
	}

	// value parameter
	@Bean(value = "laptopDell")
	Product product2() {
		var prod = new Product();
		prod.setName("Dell");
		return prod;
	}

	// no parameter
	@Primary
	@Bean("laptopLenovo")
	Product product3() {
		var prod = new Product();
		prod.setName("Lenovo");
		return prod;
	}

}
