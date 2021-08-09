package com.revature.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Jedi;
import com.revature.model.JediList;
import com.revature.service.JediService;

/* This class provides Jedis RESTful endpoints for our application
/* @RequestBody marshals the incoming JSON in the request body into our POJO 
 * @ResponseBody is implicit
 */
@RestController
public class JediController {
	
	@Autowired
	private JediService jediService;
	
	public JediController() {}
	
	@RequestMapping("/getAllJedis.app")
	public JediList getAllJedis() {
		return new JediList(jediService.getAllJedis());
	}

	@RequestMapping("/getJedi.app")
	public Jedi getJedi(@RequestBody Jedi jedi) {
		return jediService.getJedi(jedi);
	}
}
