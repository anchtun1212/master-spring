package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.aop.Person2;
import com.anchtun.beans.aop.Vehicle2;
import com.anchtun.config.ProjectConfig2;

/**
 * 
 * USING AOP,
 * 
 * @Around advice type
 * @Before advice type
 * @AfterThrowing advice type
 * @AfterReturning advice type
 */
public class Test2 {

	public static void main(String[] args) {
		// use this to check before aspect
		//boolean vehicleStarted = Boolean.FALSE;
		// use this to check around aspect
		boolean vehicleStarted = Boolean.TRUE;

		var context = new AnnotationConfigApplicationContext(ProjectConfig2.class);
		Vehicle2 vehicle = context.getBean(Vehicle2.class);
		Person2 person = context.getBean(Person2.class);
		System.out.println("Vehicle name in spring context is: " + vehicle.getName());
		System.out.println("Person name in spring context is: " + person.getName());
		System.out.println("Vehicle that person owns in spring context is: " + person.getVehicle());

		person.getVehicle().getVehicleServices().playCoran();
		person.getVehicle().getVehicleServices().moveCar(vehicleStarted);
		person.getVehicle().getVehicleServices().pressBrake();
	}
}
