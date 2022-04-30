package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.Product;
import com.anchtun.config.ProjectConfig4;

public class Test4 {

	public static void main(String[] args) {

		var context = new AnnotationConfigApplicationContext(ProjectConfig4.class);

		Product product = context.getBean(Product.class);
		System.out.println("Primar Product from spring context is: " + product.getName());

	}
}
