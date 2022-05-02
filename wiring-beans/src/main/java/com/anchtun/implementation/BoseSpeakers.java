package com.anchtun.implementation;

import org.springframework.stereotype.Component;

import com.anchtun.interfaces.Speakers;

@Component
public class BoseSpeakers implements Speakers {

	@Override
	public void makeSound() {
		System.out.println("make sound using BoseSpeakers");
	}

}
