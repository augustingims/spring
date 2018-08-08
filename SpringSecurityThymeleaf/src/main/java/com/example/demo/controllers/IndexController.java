package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
	@GetMapping("/")
	public String showInexPage() {
		return "index";
	}
	
	@GetMapping("/login")
	public String showLoginForm() {
		return "views/loginForm";
	}
}
