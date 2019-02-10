package com.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

<<<<<<< HEAD
=======
//@CrossOrigins(origins = "http://localhost:4200")
>>>>>>> f8f82d2c04d86f3ff39faceed5050bb6d2d74015
@Controller("OurController")
public class OurController {
	
	@GetMapping("/tester.app")
	public @ResponseBody ResponseEntity<String> getStuff() {
<<<<<<< HEAD
			return new ResponseEntity<>("Stuff has been received!!!", HttpStatus.OK);
	}

=======
		return new ResponseEntity<>("Stuff has been received!!!", HttpStatus.OK);
	}
>>>>>>> f8f82d2c04d86f3ff39faceed5050bb6d2d74015
}
