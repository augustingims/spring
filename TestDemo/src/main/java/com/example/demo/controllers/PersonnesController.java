package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domains.Personnes;
import com.example.demo.repository.PersonnesRepository;

@RestController
@RequestMapping("/app")
public class PersonnesController {
	
	@Autowired
	PersonnesRepository personnesRepository;
	
	@RequestMapping(value="/save", method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public void createPersonnes(@RequestBody Personnes personnes){
       personnesRepository.save(personnes);
    }
	      	      
    @GetMapping("/findall")
    public List<Personnes> findAll(){
        
        return personnesRepository.findAll();
    }
	      
    @GetMapping("/findById")
    public Personnes findById(@RequestParam("id") long id){
        
        return personnesRepository.findById(id).get();
        
    }
	      
    @GetMapping("/findbylastname")
    public Personnes fetchDataByLastName(@RequestParam("nom") String nom){
          
        return personnesRepository.findByNom(nom);
    }

}
