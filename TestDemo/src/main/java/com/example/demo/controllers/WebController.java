package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

	@RequestMapping("/")
    public String indexpage(ModelMap model){
		model.addAttribute("title", "Demo Spring");
        return "forward:/templates/index.html";
    }
	
	@RequestMapping("/{page}")
	String partialHandler(@PathVariable("page") final String page) {
		return "forward:/templates/"+page;
	}
	
}
