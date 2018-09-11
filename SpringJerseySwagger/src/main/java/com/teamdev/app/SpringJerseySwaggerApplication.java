package com.teamdev.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.teamdev.app.domain.Country;
import com.teamdev.app.repository.CountryRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"com.teamdev.app","com.teamdev.app.web.rest","com.teamdev.app.config"})
public class SpringJerseySwaggerApplication implements CommandLineRunner{

	@Autowired
	private CountryRepository countryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJerseySwaggerApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
      countryRepository.save(new Country("Cameroun","Yaoundé"));
      countryRepository.save(new Country("China","Peking"));
      countryRepository.save(new Country("German","Berlin"));
      countryRepository.save(new Country("Russia","Moscow"));
      	
	}
}
