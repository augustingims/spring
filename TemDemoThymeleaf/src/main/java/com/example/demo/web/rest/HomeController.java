package com.example.demo.web.rest;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Personnes;
import com.example.demo.service.dto.PersonneCreationDto;
import com.example.demo.service.impl.PersonneServiceImpl;

@Controller
public class HomeController {

	@Autowired
    private PersonneServiceImpl personneServiceImpl;
	
	@GetMapping("/")
	public String login() {
		return "login";
	}
	
	@GetMapping("/accueil")
	public String index() {
		return "index";
	}
	
	@GetMapping("/personnes")
	public String getAllPersonnes(Model model) {
		 model.addAttribute("personnes", personneServiceImpl.findAll());
		return "views/personne";
	}
	
	@GetMapping("/personnes-groups")
	public String getAllGroupesPersonnes(Model model) {
		 model.addAttribute("personnes", personneServiceImpl.findAll());
		return "views/groupepersonne";
	}
	
	@GetMapping("/personnes-autre")
	public String getAllAutresPersonnes(Model model) {
		return "views/autrespersonne";
	}
	
	@GetMapping("/personnes/create")
	public String createPersonnes(PersonneCreationDto personneCreationDto) {
		return "views/createpersonne";
	}
	
	@PostMapping(value="/personnes/create", params={"addRow"})
    public String addRow(PersonneCreationDto personneCreationDto, final BindingResult bindingResult) {
		personneCreationDto.getPersonnes().add(new Personnes());
        return "views/createpersonne";
    }
	
	@PostMapping(value="/personnes/create", params={"removeRow"})
    public String removeRow(PersonneCreationDto personneCreationDto, final BindingResult bindingResult, final HttpServletRequest req) {
        final Integer rowId = Integer.valueOf(req.getParameter("removeRow"));
        personneCreationDto.getPersonnes().remove(rowId.intValue());
        return "views/createpersonne";
    }
	
	@GetMapping(value = "/personnes/edit")
    public String showEditForm(Model model) {
        List<Personnes> personnes = new ArrayList<>();
        personneServiceImpl.findAll()
            .iterator()
            .forEachRemaining(personnes::add);

        model.addAttribute("form", new PersonneCreationDto(personnes));

        return "views/editpersonne";
    }
	
	@GetMapping("/savepersonne")
	public String getSavePersonne() {
		return "views/savepersonne";
	}
	
}
