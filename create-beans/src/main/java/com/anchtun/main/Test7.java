package com.anchtun.main;

import java.util.Random;
import java.util.function.Supplier;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.Product;
import com.anchtun.config.ProjectConfig5;

public class Test7 {

	public static void main(String[] args) {

		var context = new AnnotationConfigApplicationContext(ProjectConfig5.class);

		Product iphone = new Product();
		iphone.setName("Iphone 12");
		// input parameters are empty for the lambda expression () / -> return value
		Supplier<Product> iphoneSupplier = () -> iphone;

		Supplier<Product> huaweiSupplier = () -> {
			Product huawei = new Product();
			huawei.setName("Huawei p40 pro");
			return huawei;
		};

		Random random = new Random();
		int randomNumber = random.nextInt(10);
		System.out.println("randomNumber= " + randomNumber);

		if ((randomNumber % 2) == 0) {
			context.registerBean("iphone", Product.class, iphoneSupplier);
		} else {
			context.registerBean("huawei", Product.class, huaweiSupplier);
		}

		Product iphoneProduct = null;
		Product huaweiProduct = null;

		try {
			iphoneProduct = context.getBean("iphone", Product.class);
		} catch (NoSuchBeanDefinitionException e) {
			System.out.println("Error while creating iphone bean");
		}

		try {
			huaweiProduct = context.getBean("huawei", Product.class);
		} catch (NoSuchBeanDefinitionException e) {
			System.out.println("Error while creating huawei bean");
		}

		System.out.println("Programming Product name from bean context is: "
				+ (iphoneProduct != null ? iphoneProduct.getName() : huaweiProduct.getName()));

	}
}
