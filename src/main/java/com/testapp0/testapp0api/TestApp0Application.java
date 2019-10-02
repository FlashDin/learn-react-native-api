package com.testapp0.testapp0api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TestApp0Application {

	public static void main(String[] args) {
		SpringApplication.run(TestApp0Application.class, args);
	}

}
