package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Pet;

@RestController
@RequestMapping
public class PetController{
	@GetMapping
	public List <Pet> allPets() {
		List<Pet> pList = new ArrayList<>();
		pList.add(new Pet("Umasou", "Dinosuar"));
		pList.add(new Pet("toothless", "Dragon"));
		pList.add(new Pet("harold", "Seamonkey"));

		return pList;
	}}	