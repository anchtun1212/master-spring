package com.anchtun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * We can register view controllers, that create a direct mapping between the URL and the view name
 * using the ViewControllerRegistry, so NO NEED ANY CONTROLLER BETWWEN THE TWO
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/aboutme").setViewName("aboutme");
	}

}
