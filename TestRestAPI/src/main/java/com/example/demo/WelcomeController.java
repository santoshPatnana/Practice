package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@Autowired
	WelcomeService welcomeService;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcomeMessage() {
		String message = welcomeService.welcomeMessage();		
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}
