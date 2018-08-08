package com.teamdev.app.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriesController {
	
	@GetMapping(value= {"/catalogue"})
	public String cataloguePage() {
		return "views/catalogues";
	}

}
