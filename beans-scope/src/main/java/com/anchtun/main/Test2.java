package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.Product;
import com.anchtun.beans.Product2;
import com.anchtun.config.ProjectConfig;

/**
 * Eager instantiation is the default in Spring
 * Lazy instantiation
 *
 */
public class Test2 {

	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
		System.out.println("Before retreiving Objects bean from Spring context");
		//because Product has the default instantiation eager will be created by the container during the startup of the application 
		Product product = context.getBean(Product.class);
		//because Product2 is lazy will be created when we try to refer the bean (explicitly) at the first time
		Product2 product2 = context.getBean(Product2.class);
		System.out.println("After retreiving Objects bean from Spring context");
	}
}
