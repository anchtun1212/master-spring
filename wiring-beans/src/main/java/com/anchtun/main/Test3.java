package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.common.Product2;
import com.anchtun.beans.common.User2;
import com.anchtun.config.ProjectConfig3;
/**
 * 
 * using @Autowired on class field
 *
 */
public class Test3 {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig3.class);
		Product2 product = context.getBean(Product2.class);
		User2 user = context.getBean(User2.class);
		System.out.println("Product name in spring context is: " + product.getName());
		System.out.println("User name in spring context is: " + user.getName());
		System.out.println("Product that user owns in spring context is: " + user.getProduct().getName());
	}
}
