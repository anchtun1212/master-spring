package com.anchtun.beans.test6;

public class Department {

	private String name;
	
	public Department() {
		System.out.println("Department bean created by Spring using default Constructor");
	}
	
	public Department(String name) {
		System.out.println("Department bean created by Spring, using parameterized constructor, department name is: " + name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
