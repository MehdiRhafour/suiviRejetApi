package com.suivirejet.suivirejetapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableScheduling
public class SuiviRejetApiApplication {



	public static void main(String[] args) {

		System.out.println(new BCryptPasswordEncoder().encode("123"));
		SpringApplication.run(SuiviRejetApiApplication.class, args);
	}

}
