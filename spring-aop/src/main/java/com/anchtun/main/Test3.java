package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.explicit.Person3;
import com.anchtun.beans.explicit.Vehicle3;
import com.anchtun.config.ProjectConfig3;

/**
 * 
 * USING AOP,
 * 
 * Configuring advices inside AOP
 * create new annotation @LogAspect
 */
public class Test3 {

	public static void main(String[] args) {

		var context = new AnnotationConfigApplicationContext(ProjectConfig3.class);
		Vehicle3 vehicle = context.getBean(Vehicle3.class);
		Person3 person = context.getBean(Person3.class);
		System.out.println("Vehicle name in spring context is: " + vehicle.getName());
		System.out.println("Person name in spring context is: " + person.getName());
		System.out.println("Vehicle that person owns in spring context is: " + person.getVehicle());

		person.getVehicle().getVehicleServices().playCoran();
	}
}
