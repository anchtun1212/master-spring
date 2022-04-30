package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.Product;
import com.anchtun.config.ProjectConfig3;

public class Test3 {

	public static void main(String[] args) {

		var context = new AnnotationConfigApplicationContext(ProjectConfig3.class);

		Product product1 = context.getBean("laptopSonyVaio", Product.class);
		System.out.println("Product name from spring context is: " + product1.getName());
		
		Product product2 = context.getBean("laptopDell", Product.class);
		System.out.println("Product name from spring context is: " + product2.getName());
		
		Product product3 = context.getBean("laptopLenovo", Product.class);
		System.out.println("Product name from spring context is: " + product3.getName());
	}
}
