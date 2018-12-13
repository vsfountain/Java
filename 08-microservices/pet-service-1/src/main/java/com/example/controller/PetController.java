package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Pet;

@RestController
@RequestMapping("/api")
public class PetController {
	
	@GetMapping("/allpets")
	public List<Pet> allPets() {
		List<Pet> pList = new ArrayList<>();
		pList.add(new Pet("Umasou", "Dinosaur")); //anime movie "You are Umasou"
		pList.add(new Pet("Toothless", "Dragon"));
		pList.add(new Pet("Harold", "Seamonkey"));
		pList.add(new Pet("Smaug", "Giraffe"));
		
		System.out.println("getting all pets");
		
		return pList;
	}
}
