package com.anchtun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anchtun.interfaces.Speakers;
import com.anchtun.interfaces.Tyres;

@Component
public class VehicleServices {

	@Autowired
	private Speakers speakers;

	@Autowired
	private Tyres tyres;

	public void playCoran() {
		speakers.makeSound();
	}

	public void moveCar() {
		tyres.rotate();
	}
}
