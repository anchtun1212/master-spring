package com.anchtun.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anchtun.beans.Department;
import com.anchtun.config.ProjectConfig5;

public class Test6 {

	public static void main(String[] args) {

		var context = new AnnotationConfigApplicationContext(ProjectConfig5.class);

		Department department = context.getBean(Department.class);
		System.out.println("Component Department name from spring context is: " + department.getName());
		department.printHello();
		//will call @PreDestroy
		context.close();

	}
}
