package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
	
	@RequestMapping(value="/next.app", method=RequestMethod.GET)
	public String getPage() {
		//return "redirect:http://google.com";
		//return "redirect:/nextpage.html";
		//return "nextpage.html";
		
		return "ge";
	}
}
