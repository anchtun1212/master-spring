package com.anchtun.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

@Configuration
public class AnchtunConfiguration {

	@Bean
	public BasicAuthenticationInterceptor basicAuthenticationInterceptor() {
		//return new BasicAuthenticationInterceptor("username", "password");
		return new BasicAuthenticationInterceptor("anchtun@gmail.com", "pass12345678");
	}
}
