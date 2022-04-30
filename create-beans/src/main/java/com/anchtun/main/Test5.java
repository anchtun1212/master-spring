package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.User;
import com.anchtun.config.ProjectConfig5;

public class Test5 {

	public static void main(String[] args) {

		var context = new AnnotationConfigApplicationContext(ProjectConfig5.class);

		User user = context.getBean(User.class);
		System.out.println("Component User name from spring context is: " + user.getName());
		user.helloHello();

	}
}
