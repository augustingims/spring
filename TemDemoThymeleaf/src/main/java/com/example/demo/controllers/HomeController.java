package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping(value= {"/","/plain-page"})
	public String index() {
		return "index";
	}
	
	@GetMapping(value= {"/pricing-table"})
	public String pricingTable() {
		return "pricing-tables";
	}
}
