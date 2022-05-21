package com.anchtun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.anchtun.repository")
@EntityScan("com.anchtun.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class AnctunApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnctunApplication.class, args);
	}

}
