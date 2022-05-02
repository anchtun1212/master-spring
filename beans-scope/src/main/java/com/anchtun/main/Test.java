package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.User;
import com.anchtun.config.ProjectConfig;

/**
 * 
 * Singleton bean scope
 * Singleton is the default scope of a bean in Spring
 *
 */
public class Test {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		User user1 = context.getBean(User.class);
		User user2 = context.getBean("userBean", User.class);
		System.out.println("hashcode for the object user1: " + user1.hashCode());
		System.out.println("hashcode for the object user2: " + user2.hashCode());
		if (user1 == user2) {
			System.out.println("User bean is a Singleton scoped bean");
		}
	}
}
