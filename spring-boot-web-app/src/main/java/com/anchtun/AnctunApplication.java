package com.anchtun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// exclude DataSourceAutoConfiguration and I don't want that the auto-configuration will be created
// and also bean should not be created by spring boot when the server start up
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AnctunApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnctunApplication.class, args);
	}

}
