package com.anchtun.beans;

import org.springframework.stereotype.Component;

@Component("userBean")
public class User {

	private String name = "Anchtun";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
