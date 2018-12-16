package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Pet;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/api")
public class HystrixController {
	//allows a microservice to send HTTP requests to a RESTfull server
	RestTemplate restTemp = new RestTemplate();
	
	
//we're using hystrix for circuit breaking	
@HystrixCommand(fallbackMethod= "hystrixNotAKeyword")	
@GetMapping("/fetchpets")
public List<Pet>fetchPets(){
	List<Pet>pList =restTemp.getForObject("http://localhost:8765/pet-service-1/api/allPets",
			List.class);
			return pList;
}
 public List<Pet>hystrixNotAKeyword(){
	 System.out.println("not.......a keyword.Seriouslu, I'm not trolling");
	 List<Pet>pList= new ArrayList<>();
	 pList.add(new Pet("Finn", "The Human"));
	 pList.add(new Pet("Gir", "What?"));
	 
	 return pList;
 	 
 }
}


