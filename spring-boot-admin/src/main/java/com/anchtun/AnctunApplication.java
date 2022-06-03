package com.anchtun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
public class AnctunApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnctunApplication.class, args);
	}

}
