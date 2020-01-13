package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("model")
public class PlaninarWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaninarWebApplication.class, args);
	}

}
