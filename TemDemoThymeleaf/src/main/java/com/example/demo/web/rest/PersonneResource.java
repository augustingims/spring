package com.example.demo.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.Personnes;
import com.example.demo.repository.PersonnesRepository;
import com.example.demo.service.dto.PersonneCreationDto;
import com.example.demo.service.dto.PersonnesDto;
import com.example.demo.service.impl.PersonneServiceImpl;

@Controller
public class PersonneResource {

	@Autowired
	private PersonneServiceImpl personneServiceImpl;
	
	@Autowired
	private PersonnesRepository personnesRepository;
	
	@GetMapping("/getAllPersonnes")
	public ResponseEntity<List<Personnes>> getAllPersonnes() throws URISyntaxException {
		
		return ResponseEntity.created(new URI("/personnes"))
				.body(personnesRepository.findAll());
	}
	
	@PostMapping("/personne")
	public ResponseEntity<String> createPersonne(@Valid PersonnesDto c) throws URISyntaxException {
		
		personneServiceImpl.save(c);
		
		return ResponseEntity.created(new URI("/personne"))
				.body("Opération éffectuée avec succès");
	}
	
	@PostMapping(value="/personnes/create", params={"save"})
    public String saveSeedstarter(PersonneCreationDto personneCreationDto, final BindingResult bindingResult, final ModelMap model,RedirectAttributes attributes,HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "views/createpersonne";
        }
        personneServiceImpl.saveAll(personneCreationDto.getPersonnes());
        model.clear();
        attributes.addFlashAttribute("todos", "todos");
        return "redirect:/personnes";
    }
	
	@PostMapping("/personnes/save")
	public String createPersonnes(@ModelAttribute PersonneCreationDto form, Model model) {
		
		personneServiceImpl.saveAll(form.getPersonnes());

        model.addAttribute("personnes", personneServiceImpl.findAll());
		
		return "redirect:/personnes";
	}
	
}
