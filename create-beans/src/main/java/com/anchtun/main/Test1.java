package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.Product;
import com.anchtun.config.ProjectConfig1;

public class Test1 {

	public static void main(String[] args) {

		/**
		 * this object is NOT a bean
		 */
		Product productNonSC = new Product();
		productNonSC.setName("Iphone 12");
		System.out.println("Product from non-spring context is: " + productNonSC.getName());

		/**
		 * the var keyword was introduced in Java 10. Type inference is used in var
		 * keyword in which it detects automatically the datatype of a variable based on
		 * the surrounding context.
		 */
		var context = new AnnotationConfigApplicationContext(ProjectConfig1.class);

		/**
		 * this object is a bean: we get it from the context (memory inside spring
		 * framework)
		 */
		Product productSC = context.getBean(Product.class);
		System.out.println("Product from spring context is: " + productSC.getName());
		
		/**
		 * we don't need to use any explicit casting while fetching a bean from context.
		 * Spring is smart enough to look of the bean of the type you requested in its
		 * context. if such a bean doesn't exist, Spring will throw an exception.
		 */
		String hello = context.getBean(String.class);
		System.out.println("String value from spring context is: " + hello);

		Integer number = context.getBean(Integer.class);
		System.out.println("Integer value from spring context is: " + number);

	}
}
