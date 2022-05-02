package com.anchtun.implementation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.anchtun.interfaces.Tyres;

@Component
@Primary
public class MichelinTypes implements Tyres {

	@Override
	public void rotate() {
		System.out.println("rotate using MichelinTypes");
	}

}
