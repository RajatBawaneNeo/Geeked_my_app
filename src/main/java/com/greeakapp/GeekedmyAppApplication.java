package com.greeakapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.greeakapp.repository")
public class GeekedmyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeekedmyAppApplication.class, args);
	}

}
