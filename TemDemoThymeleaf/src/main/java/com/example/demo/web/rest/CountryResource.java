package com.example.demo.web.rest;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Country;
import com.example.demo.repository.CountryRepository;
import com.example.demo.service.impl.CountryServiceImpl;

@Controller
public class CountryResource {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CountryServiceImpl countryServiceImpl;

	@GetMapping("/country")
	public String getAll(String country,Model model) {
		if(country!=null) {
			model.addAttribute("countries", countryServiceImpl.getListeCountry(country,country));
		}else {
			model.addAttribute("countries", countryRepository.findAll());
		}
		
		return "views/country";
	}

	@PostMapping("/save")
	public ResponseEntity<String> save(@Valid Country c) throws URISyntaxException {
		Country result = countryRepository.save(c);
		return ResponseEntity.created(new URI("/api/country/" + result.getId())).body("Operation effectue avec succes");
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestParam Long id,@RequestBody Country c) throws URISyntaxException {
		Country result = countryRepository.findById(id).get();
		result.setCapital(c.getCapital());
		result.setName(c.getName());
		countryRepository.save(result);
		return ResponseEntity.created(new URI("/api/country/" + result.getId()))
				.body("Modification effectue avec succes");
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam Long id) throws URISyntaxException {
		countryRepository.deleteById(id);
		return ResponseEntity.created(new URI("/api/country")).body("Pays " + id + " supprimé avec succes");
	}

	@GetMapping("/findOne")
	@ResponseBody
	public Country findOne(Long id) {
		return countryRepository.findById(id).get();
	}

	@GetMapping("/findByNameAndCapital/{name}/{capital}/{max}")
	public String findByNameAndCapital(@PathVariable(value = "name") String name,
			@PathVariable(value = "capital") String capital, @PathVariable(value = "max") Long max) {
		countryServiceImpl.getListeCountryWthMax(name, capital, max);
		return "views/country";
	}
}
