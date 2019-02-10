package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {
	@Autowired
	ProducerConfig prod;
	
	@GetMapping("/send")
	public String sendMsg(@RequestParam("msg") String msg) {
		System.out.println("in the producer controller");
		prod.produceMsg(msg);
		return "Done";
	}
}
