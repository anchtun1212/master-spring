package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.test8.Person;
import com.anchtun.beans.test8.Vehicle;
import com.anchtun.config.ProjectConfig6;

/**
 * 
 * Full example
 *
 */
public class Test8 {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig6.class);
		//get beanNames for Vehicle object /make debug to see
		String [] vehicles = context.getBeanNamesForType(Vehicle.class);
		Vehicle vehicle = context.getBean(Vehicle.class);
		//get beanNames for Person object /make debug to see
		String [] persons = context.getBeanNamesForType(Person.class);
		Person person = context.getBean(Person.class);
		System.out.println("Vehicle name in spring context is: " + vehicle.getName());
		System.out.println("Person name in spring context is: " + person.getName());
		System.out.println("Vehicle that person owns in spring context is: " + person.getVehicle());
		
		/*vehicle.getVehicleServices().playCoran();
		vehicle.getVehicleServices().moveCar();*/
		
		person.getVehicle().getVehicleServices().playCoran();
		person.getVehicle().getVehicleServices().moveCar();
	}
}
