package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.Product2;
import com.anchtun.beans.User3;
import com.anchtun.config.ProjectConfig3;
/**
 * 
 * using @Autowired on setter method
 *
 */
public class Test4 {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig3.class);
		Product2 product = context.getBean(Product2.class);
		User3 user = context.getBean(User3.class);
		System.out.println("Product name in spring context is: " + product.getName());
		System.out.println("User name in spring context is: " + user.getName());
		System.out.println("Product that user owns in spring context is: " + user.getProduct().getName());
	}
}
