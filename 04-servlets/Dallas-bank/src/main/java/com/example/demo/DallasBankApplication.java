package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.User;

@SpringBootApplication
public class DallasBankApplication {

	public static void main(String[] args) {
		User user = new User("User");
		
		SpringApplication.run(DallasBankApplication.class, args);
	}

}

