package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
<<<<<<< HEAD
	@RequestMapping(value="/next.app", method=RequestMethod.GET)
	public String getPage() {
		return "nextpage.html";
=======
	
	@RequestMapping(value="/next.app", method=RequestMethod.GET)
	public String getPage() {
		//return "redirect:http://google.com";
		//return "redirect:/nextpage.html";
		//return "nextpage.html";
		
		return "ge";
>>>>>>> 913c752bd8fc06f213baa704e33a2fdbdf48e72f
	}
}
