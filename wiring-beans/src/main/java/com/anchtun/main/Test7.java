package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.test7.User7;
import com.anchtun.config.ProjectConfig5;

/**
 * 
 * UnsatisfiedDependencyException due to circular dependencies
 * A circular dependency will happen if 2 beans are waiting for each to create inside the Spring context in order
 * to do auto-wiring
 *
 */
public class Test7 {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig5.class);
		User7 user = context.getBean(User7.class);
		System.out.println("User name in spring context is: " + user.getName());
		System.out.println("Product that user owns in spring context is: " + user.getProduct().getName());
	}
}
