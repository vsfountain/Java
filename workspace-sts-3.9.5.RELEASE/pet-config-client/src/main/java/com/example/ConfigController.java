package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {
	
	@Value("${message:Lookat this message}")
    private String configMessage;

	
	@GetMapping("/test")
	public String ourConfigExample() {
		return configMessage;
	}

}
