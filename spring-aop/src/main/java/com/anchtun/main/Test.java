package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.Person;
import com.anchtun.beans.Vehicle;
import com.anchtun.config.ProjectConfig;

/**
 * 
 * many non business logic code in VehicleServices class code
 * WITHOUT AOP,
 * TO UNDERSTAND THE PROBLEM TO BE RESOLVED
 */
public class Test {

	public static void main(String[] args) {
		boolean vehicleStarted = Boolean.TRUE;
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		Vehicle vehicle = context.getBean(Vehicle.class);
		Person person = context.getBean(Person.class);
		System.out.println("Vehicle name in spring context is: " + vehicle.getName());
		System.out.println("Person name in spring context is: " + person.getName());
		System.out.println("Vehicle that person owns in spring context is: " + person.getVehicle());
		
		person.getVehicle().getVehicleServices().playCoran(vehicleStarted);
		person.getVehicle().getVehicleServices().moveCar(vehicleStarted);
	}
}
