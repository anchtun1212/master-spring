package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.test6.User5;
import com.anchtun.config.ProjectConfig4;

public class Test6 {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig4.class);
		//call user will inject department
		User5 user = context.getBean(User5.class);
		System.out.println("User name in spring context is: " + user.getName());
		System.out.println("Department which the user belongs in spring context is: " + user.getDepartment().getName());
	}
}
