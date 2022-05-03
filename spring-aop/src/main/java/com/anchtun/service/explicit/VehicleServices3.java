package com.anchtun.service.explicit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anchtun.annotation.LogAspect;
import com.anchtun.interfaces.Speakers;

@Component
public class VehicleServices3 {

	@Autowired
	private Speakers speakers;

	@LogAspect
	public void playCoran() {
		speakers.makeSound();
	}
}
