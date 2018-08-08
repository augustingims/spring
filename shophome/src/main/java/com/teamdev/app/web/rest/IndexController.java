package com.teamdev.app.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.teamdev.app.services.dto.UserDTO;

@Controller
public class IndexController {
	
	@GetMapping(value= {"/","/home","/index","/accueil"})
	public String homePage() {
		return "index";
	}
	
	@GetMapping(value= {"/login"})
	public String loginPage(Model model) {
		model.addAttribute("loginDTO",new UserDTO());
		return "views/login";
	}
	
	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("userDTO",new UserDTO());
		return "views/register";
	}
	
	@GetMapping(value= {"/favoris"})
	public String favorisPage() {
		return "views/favoris";
	}

}
