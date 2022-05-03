package com.anchtun.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("personBean")
public class Person {

	private String name = "Anchtun";
	private final Vehicle vehicle;

	@Autowired
	public Person(Vehicle vehicle) {
		System.out.println("Person bean created by Spring");
		this.vehicle = vehicle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

}
