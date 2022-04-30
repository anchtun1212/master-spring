package com.anchtun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.anchtun.beans.Product;

/*
 * Spring @Configuration annotation is part of the spring core framework.
 * Spring Configuration annotation indicates that the class has @Bean definition methods.
 * So Spring container can process the class and generate Spring Beans to be used in the application.
 */
@Configuration
public class ProjectConfig1 {

	/**
	 * 
	 * @Bean which lets spring know that it needs to call this method when it
	 *       initializes its context and adds the returned value to the context
	 */
	@Bean
	Product product1() {
		var prod = new Product();
		prod.setName("Laptop Sony vaio");
		return prod;
	}
	
	/**
	 * the method names usually follow verbs notation. But for the methods which we will use to create beans,
	 * we can use nouns as names. This will be a good practice as the method names will become bean names as
	 * well in the context.
	 */
	@Bean
	String helloWorld() {
		return "Hello world";
	}

	@Bean
	Integer favoriteNumber() {
		return 5;
	}

}
