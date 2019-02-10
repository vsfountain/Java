package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AnimalSound;

@RestController
@RequestMapping("/api")
public class SoundController {
	@GetMapping("/sound")
	public AnimalSound getSound() {
		AnimalSound s = new AnimalSound("weweweweweweww", 72.1);
		return s;
	}
}
