package com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootAppilcation;


@SpringBootApplication
public interface MainDriver {
	
	public static void main (String[]args){
		SpringApplication.run(MainDriver.class, args);
		
	}

}
