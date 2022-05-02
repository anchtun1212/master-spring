package com.anchtun.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("user2Bean")
@Scope("prototype")
public class User2 {

	private String name = "Anchtun";

	public User2() {
		System.out.println("User2 bean created by Spring");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
