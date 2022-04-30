package com.anchtun.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * to tell spring it needs to search for classes annotated with stereotype annotations.
 * so we use @ComponentScan annotation over the configuration class
 */
@Configuration
@ComponentScan(basePackages = "com.anchtun.beans")
public class ProjectConfig5 {

}
