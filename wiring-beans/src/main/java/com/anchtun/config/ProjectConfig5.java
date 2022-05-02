package com.anchtun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.anchtun.beans.test7.Product7;

@Configuration
@ComponentScan(basePackages = "com.anchtun.beans.test7")
public class ProjectConfig5 {

	@Bean
	Product7 product1() {
		var product = new Product7();
		product.setName("Iphone 13");
		return product;
	}
}
