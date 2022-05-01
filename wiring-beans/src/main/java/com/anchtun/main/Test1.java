package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.common.Product;
import com.anchtun.beans.common.User;
import com.anchtun.config.ProjectConfig1;

public class Test1 {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig1.class);
		Product product = context.getBean(Product.class);
		User user = context.getBean(User.class);
		System.out.println("Product name in spring context is: " + product.getName());
		System.out.println("User name in spring context is: " + user.getName());
		System.out.println("Product that user owns in spring context is: " + user.getProduct().getName());
	}
}
