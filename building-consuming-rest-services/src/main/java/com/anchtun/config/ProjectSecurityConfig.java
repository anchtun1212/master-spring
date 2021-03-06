package com.anchtun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
		// not recommended approach
		//.csrf().disable()
		// here we disable csrf for all web application but enable it for this specific action
		.csrf().ignoringAntMatchers("/saveMsg")
		// disable csrf for all public paths because there is no secure data
		.ignoringAntMatchers("/public/**")
		// disable csrf
		.ignoringAntMatchers("/api/**")
		// disable csrf: will be invoked from java code and not from browser
		.ignoringAntMatchers("/anchtun-api/**")
		.ignoringAntMatchers("/anchtun/actuator/**").and()
		// this line is mandatory for any kind of configuration  
		.authorizeRequests()
		// will configure page by page
		// we can use one of those three matchers: mvcMatchers/antMatchers/regexMatchers
		// use regexMatchers
		// uses can go to the home page only if they are authenticated
		.regexMatchers("/home").authenticated()
		// use antMatchers
		.antMatchers("/aboutme").permitAll()
		.mvcMatchers("/saveMsg2").permitAll()
		// Allow this request only for authenticated users 
		//.mvcMatchers("/contact").authenticated()
		.mvcMatchers("/contact").authenticated()
		.mvcMatchers("login").permitAll()
		// only ADMIN can access to the page
		.antMatchers("/messages").hasRole("ADMIN")
		.antMatchers("/skillDB").permitAll()
		.antMatchers("/skillByLevelDB").permitAll()
		.mvcMatchers("/userProfile").authenticated()
		.mvcMatchers("/updateprofile").authenticated()
		.mvcMatchers("/anchtun/actuator/**").hasRole("ADMIN")
		.mvcMatchers("/admin/**").hasRole("ADMIN")
		// permit all that are under public: register page,...
		.antMatchers("/public/**").permitAll()
		// need to be authenticated in order to consume api endpoints
		.mvcMatchers("/api/**").authenticated()
		.antMatchers("/anchtun-api/**").authenticated()
		.and().formLogin()
		// configure our custom login page (not login page provided by default from Spring)
		.loginPage("/login").defaultSuccessUrl("/home").failureUrl("/login?error=true").permitAll()
		.and().logout().logoutSuccessUrl("/login?logout=true")
		// after logout = true so invalidateHttpSession = true
		.invalidateHttpSession(true).permitAll()
		.and().httpBasic();
	}
	
	// BCryptPasswordEncoder: Most commonly used for Hashing
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
