package com.anchtun.beans.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("person2Bean")
public class Person2 {

	private String name = "Anchtun";
	private final Vehicle2 vehicle;

	@Autowired
	public Person2(Vehicle2 vehicle) {
		System.out.println("Person bean created by Spring");
		this.vehicle = vehicle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vehicle2 getVehicle() {
		return vehicle;
	}

}
