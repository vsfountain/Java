package com.example;

/**
 * @author Kristen Kavanagh
 *
 */
public class OurController {

	/**
	 * 
	 */
	//@CrossOrigins(Origins="http://localHost:4200")
	@Controller("OurController")
	public OurController() {

		@GetMapping("/test.app")
	public @ResponseBody ResponseEntity<String> getStuff() {
		return new ResponseEntity<>("Stuff has been received!!", HttpStatus.OK)

	}

}
