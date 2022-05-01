package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.Product2;
import com.anchtun.beans.User4;
import com.anchtun.config.ProjectConfig3;
/**
 * 
 * using @Autowired with constructor
 *
 */
public class Test5 {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig3.class);
		Product2 product = context.getBean(Product2.class);
		User4 user = context.getBean(User4.class);
		System.out.println("Product name in spring context is: " + product.getName());
		System.out.println("User name in spring context is: " + user.getName());
		System.out.println("Product that user owns in spring context is: " + user.getProduct().getName());
	}
}
