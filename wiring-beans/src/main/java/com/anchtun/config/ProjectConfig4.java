package com.anchtun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.anchtun.beans.test6.Department;

@Configuration
@ComponentScan(basePackages = "com.anchtun.beans.test6") // used to detect user bean used in Test6
public class ProjectConfig4 {

	@Bean
	Department department1() {
		return new Department("IT");
	}

	@Bean
	/**
	 * 
	 * Solution 2
	 */
	// @Primary
	Department department2() {
		return new Department("HR");
	}

	@Bean
	Department department3() {
		return new Department("Finance");
	}
}
