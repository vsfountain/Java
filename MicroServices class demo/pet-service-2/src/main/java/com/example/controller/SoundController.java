package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AnimalSound;

@RestController
@RequestMapping
public class SoundController {

	@GetMapping
	public AnimalSound getSound() {
AnimalSound s = new AnimalSound ("WEEEE",721.1);
		return s;

}}

