package com.anchtun.implementation;

import org.springframework.stereotype.Component;

import com.anchtun.interfaces.Tyres;

@Component
public class BridgeStoneTypes implements Tyres {

	@Override
	public String rotate() {
		System.out.println("rotate using BridgeStoneTypes");
		return "rotate";
	}

}
