package com.anchtun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

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
		.csrf().ignoringAntMatchers("/saveMsg").and()
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
		.mvcMatchers("/contact").permitAll()
		.mvcMatchers("login").permitAll()
		// only ADMIN can access to the page
		.antMatchers("/messages").hasRole("ADMIN")
		.antMatchers("/skillDB").permitAll()
		.antMatchers("/skillByLevelDB").permitAll()
		.and().formLogin()
		// configure our custom login page (not login page provided by default from Spring)
		.loginPage("/login").defaultSuccessUrl("/home").failureUrl("/login?error=true").permitAll()
		.and().logout().logoutSuccessUrl("/login?logout=true")
		// after logout = true so invalidateHttpSession = true
		.invalidateHttpSession(true).permitAll()
		.and().httpBasic();
		
	}
	
	// In-merory authentication: NEVER EVER use in-memory authentication for PROD (only use for POC)
	// we can add many users as we want
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("aymen").password("aymen12345").roles("USER")
		.and()
		.withUser("mohamed").password("mohamed12345").roles("USER", "ADMIN")
		.and()
		.withUser("anchtun").password("anchtun123").roles("USER", "ADMIN")
		.and()
		// deprecated: not recommended but we will use it only for POC
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
}
