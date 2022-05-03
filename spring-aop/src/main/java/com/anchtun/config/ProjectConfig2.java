package com.anchtun.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "com.anchtun.beans.aop", "com.anchtun.service.aop", "com.anchtun.implementation",
		"com.anchtun.aspect" })
@EnableAspectJAutoProxy
public class ProjectConfig2 {

}
