package com.anchtun.service.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anchtun.interfaces.Speakers;
import com.anchtun.interfaces.Tyres;

@Component
public class VehicleServices2 {

	@Autowired
	private Speakers speakers;

	@Autowired
	private Tyres tyres;

	public void playCoran() {
		//to check if there @AfterThrowing aspect catch this exception
		//int a = 5/0;
		speakers.makeSound();
	}

	public void moveCar(boolean isVehicleStarted) {
		tyres.rotate();
	}
	
	public String pressBrake() {
		return "Pressed";
	}
}
