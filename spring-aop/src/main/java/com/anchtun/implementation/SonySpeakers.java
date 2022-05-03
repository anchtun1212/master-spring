package com.anchtun.implementation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.anchtun.interfaces.Speakers;

@Component
@Primary
public class SonySpeakers implements Speakers {

	@Override
	public String makeSound() {
		System.out.println("make coran sound using SonySpeakers");
		return "Coran";
	}

}
