package com.anchtun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/**
		 * permitAll(): Permit (allow) all requests inside the web application
		 */
		/*http.authorizeRequests().
		anyRequest().permitAll()
		.and().formLogin()// html form (formLogin)
		.and().httpBasic();// like Rest APIs (httpBasic)*/
		
		/**
		 * denyAll(): Deny all requests inside the web application
		 */
		/*http.authorizeRequests().
		anyRequest().denyAll()
		.and().formLogin()// html form (formLogin)
		.and().httpBasic();// like Rest APIs (httpBasic)*/
		
	}
}
