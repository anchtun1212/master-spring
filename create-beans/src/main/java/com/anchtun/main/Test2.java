package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.Product;
import com.anchtun.config.ProjectConfig2;

public class Test2 {

	public static void main(String[] args) {

		var context = new AnnotationConfigApplicationContext(ProjectConfig2.class);

		try {
			// will get NoUniqueBeanDefinitionException
			Product productSC = context.getBean(Product.class);
			System.out.println("Product from spring context is: " + productSC.getName());

		} catch (Exception e) {
			e.printStackTrace();
		}
		// now ok
		Product productLaptopSonyVaio = context.getBean("product1", Product.class);
		System.out.println("Product from spring context is: " + productLaptopSonyVaio.getName());
	}
}
