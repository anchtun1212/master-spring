package com.anchtun.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Department {

	private String name;

	@PostConstruct
	public void initialize() {
		this.name = "IT";
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Destroying Department bean");
	}

	public void printHello() {
		System.out.println("Hello from Component Department bean");
	}

	/**
	 * 
	 * @return
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
