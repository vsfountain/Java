package com.revature.soap;

import javax.jws.WebService;

@WebService(endpointInterface = "com.revature.soap.JediGreeting", serviceName = "jediGreetingService")
public class JediGreetingForce implements JediGreeting {

	@Override
	public String getMessage(String message) {
		return "Peter: " + message;
	}

}
