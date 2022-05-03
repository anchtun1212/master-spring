package com.anchtun.beans.explicit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("person3Bean")
public class Person3 {

	private String name = "Anchtun";
	private final Vehicle3 vehicle;

	@Autowired
	public Person3(Vehicle3 vehicle) {
		System.out.println("Person bean created by Spring");
		this.vehicle = vehicle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vehicle3 getVehicle() {
		return vehicle;
	}

}
