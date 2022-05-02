package com.anchtun.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.anchtun.service", "com.anchtun.implementation"})
@ComponentScan(basePackageClasses = {com.anchtun.beans.test8.Person.class, com.anchtun.beans.test8.Vehicle.class})
public class ProjectConfig6 {

}
