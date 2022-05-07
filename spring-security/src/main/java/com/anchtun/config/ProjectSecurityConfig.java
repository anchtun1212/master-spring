package com.anchtun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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
		
		http
		// thymeleaf will disable csrf by default, so you need to add this line of code if you are using (angular, react...)
		// because spring will block all update requests POST/PUT will be stopped with 403 error
		.csrf().disable()
		// this line is mandatory for any kind of configuration  
		.authorizeRequests()
		// will configure page by page
		// we can use one of those three matchers: mvcMatchers/antMatchers/regexMatchers
		// use regexMatchers
		.regexMatchers("/home").permitAll()
		// use antMatchers
		.antMatchers("/aboutme").permitAll()
		.mvcMatchers("/skill/**").permitAll()
		.mvcMatchers("/skill-req-param").permitAll()
		// use the second constructor of mvcMatchers
		.mvcMatchers(HttpMethod.POST, "/saveMsg").permitAll()
		.mvcMatchers("/saveMsg2").permitAll()
		// Allow this request only for authenticated users 
		.mvcMatchers("/contact").authenticated()
		.and().formLogin()
		.and().httpBasic();
		
	}
}
