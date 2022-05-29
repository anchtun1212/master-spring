package com.anchtun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.anchtun.proxy")
public class AnctunApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnctunApplication.class, args);
	}

}
