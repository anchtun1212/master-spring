package com.anchtun.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "com.anchtun.beans.explicit", "com.anchtun.service.explicit", "com.anchtun.implementation",
		"com.anchtun.aspect" })
@EnableAspectJAutoProxy
public class ProjectConfig3 {

}
