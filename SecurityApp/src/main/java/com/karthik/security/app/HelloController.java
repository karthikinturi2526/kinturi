package com.karthik.security.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	
	@GetMapping("/hello")
	public String hello() {
		return "Secure Application";
		
	}
	
	@GetMapping("/bye")
	public String bye() {
		return "Get Lost!";
		
	}


}
