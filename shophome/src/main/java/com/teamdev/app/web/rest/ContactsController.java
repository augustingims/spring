package com.teamdev.app.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactsController {
	
	@GetMapping(value= {"/contacts"})
	public String contactPage() {
		return "views/contacts";
	}

}
