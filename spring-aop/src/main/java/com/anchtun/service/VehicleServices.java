package com.anchtun.service;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anchtun.interfaces.Speakers;
import com.anchtun.interfaces.Tyres;

@Component
public class VehicleServices {

	private Logger log = Logger.getLogger(VehicleServices.class.getName());

	@Autowired
	private Speakers speakers;

	@Autowired
	private Tyres tyres;

	/**
	 * 
	 * many code here NOT business logic code also the if is not a business logic
	 * code is like security check the only business logic is: coran = speakers.makeSound();
	 * MANY REDUNDANCY IN THE CODE, DIFFICULT TO MAINTAIN
	 * the code contains logging, security check (if), calculate difference between start and end 
	 */
	public void playCoran(boolean isVehicleStarted) {
		Instant start = Instant.now();
		log.info("Start method makeSound");
		if (isVehicleStarted) {
			// the only business logic in this method
			speakers.makeSound();
		} else {
			log.info("Vehicle not started yet");
		}
		Instant end = Instant.now();
		log.info("End method makeSound");
		long timeElapsed = Duration.between(start, end).toMillis();
		System.out.println("Time took to execute the method makeSound: " + timeElapsed);
	}

	public void moveCar(boolean isVehicleStarted) {
		Instant start = Instant.now();
		log.info("Start method rotate");
		if (isVehicleStarted) {
			// the only business logic in this method
			tyres.rotate();
		} else {
			log.info("Vehicle not started yet");
		}
		Instant end = Instant.now();
		log.info("End method rotate");
		long timeElapsed = Duration.between(start, end).toMillis();
		System.out.println("Time took to execute the method rotate: " + timeElapsed);
	}
}
