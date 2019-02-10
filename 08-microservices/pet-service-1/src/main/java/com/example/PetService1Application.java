package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PetService1Application {

	public static void main(String[] args) {
		SpringApplication.run(PetService1Application.class, args);
	}

}

