package com.teamdev.app.resources;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
	
	@GetMapping("/")
	public String homePage(Principal principal) {
		return "Bienvenu(e) Mr/Mme "+principal.getName();
	}

}
