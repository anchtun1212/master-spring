package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.User2;
import com.anchtun.config.ProjectConfig;

/**
 * 
 * Prototype scope
 * Every time we request a reference of bean, Spring will create new object instance
 *
 */
public class Test3 {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		User2 user1 = context.getBean(User2.class);
		User2 user2 = context.getBean("user2Bean", User2.class);
		System.out.println("hashcode for the object user1: " + user1.hashCode());
		System.out.println("hashcode for the object user2: " + user2.hashCode());
		if (user1 != user2) {
			System.out.println("User2 bean is a Prototype scoped bean");
		}
	}
}
