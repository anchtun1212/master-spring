package com.anchtun.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ExchangeFilterFunctions;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AnchtunConfiguration {

	@Bean
	public BasicAuthenticationInterceptor basicAuthenticationInterceptor() {
		// return new BasicAuthenticationInterceptor("username", "password");
		return new BasicAuthenticationInterceptor("anchtun@gmail.com", "pass12345678");
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		return restTemplateBuilder.basicAuthentication("anchtun@gmail.com", "pass12345678").build();
	}

	@Bean
	public WebClient webClient() {
		return WebClient.builder()
				.filter(ExchangeFilterFunctions.basicAuthentication("anchtun@gmail.com", "pass12345678"))
				.build();
	}
}
