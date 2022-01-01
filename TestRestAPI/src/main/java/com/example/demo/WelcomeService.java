package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
	
	public String welcomeMessage() {
		return "Welcome to world..";
	}
}
