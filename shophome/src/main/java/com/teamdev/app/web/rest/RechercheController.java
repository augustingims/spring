package com.teamdev.app.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RechercheController {
	
	@GetMapping(value= {"/recherche"})
	public String recherchePage() {
		return "views/recherche";
	}

}
