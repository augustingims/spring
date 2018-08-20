package com.teamdev.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PagesControllers {
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String homePage() {
		return "index";
	}
    
    @GetMapping("/users")
	public String loginPage() {
		return "views/users";
	}
}
