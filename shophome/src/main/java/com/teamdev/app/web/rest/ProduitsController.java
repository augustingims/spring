package com.teamdev.app.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProduitsController {
	
	@GetMapping(value= {"/produits"})
	public String detailsPage() {
		return "views/details";
	}

}
