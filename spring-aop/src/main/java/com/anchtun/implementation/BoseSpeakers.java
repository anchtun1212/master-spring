package com.anchtun.implementation;

import org.springframework.stereotype.Component;

import com.anchtun.interfaces.Speakers;

@Component
public class BoseSpeakers implements Speakers {

	@Override
	public String makeSound() {
		System.out.println("make coran sound using BoseSpeakers");
		return "Coran";
	}

}
