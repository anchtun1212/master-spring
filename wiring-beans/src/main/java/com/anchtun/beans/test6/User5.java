package com.anchtun.beans.test6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class User5 {

	private String name = "Anchtun";
	private Department department;
	
	/**
	 * 
	 * will cause NoUniqueBeanDefinitionException: No qualifying bean of type 'com.anchtun.beans.Department' available: 
	 * expected single matching bean but found 3: department1,department2,department3 
	 */
	/*@Autowired 
	public User5(Department department) {
		System.out.println("User5 bean created by Spring using parameterized constructor");
		this.department = department;
	}*/
	
	/**
	 * 
	 * So Spring find by Type but he found 3 instances of the object Department, so we can handle this error by
	 * 1- change the parameter name in the constructor (example: public User5(Department department1))
	 * 2- Add @Primary annotation in the ProjectConfig4 class on the bean that you want to be Primary
	 * 3- Use Qualifier (example: public User5(Department department))
	 */
	
	/**
	 * 
	 * Solution 1
	 */
	/*@Autowired 
	public User5(Department department1) {
		System.out.println("User5 bean created by Spring using parameterized constructor");
		this.department = department1;
	}*/
	
	/**
	 * 
	 * Solution 3
	 */
	@Autowired 
	public User5(@Qualifier("department3") Department department) {
		System.out.println("User5 bean created by Spring using parameterized constructor");
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
