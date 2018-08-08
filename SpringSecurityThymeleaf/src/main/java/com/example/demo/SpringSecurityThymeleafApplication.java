package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@SpringBootApplication
public class SpringSecurityThymeleafApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityThymeleafApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		{
			User admin = new User("admin@gmail.com","admin","admin");
			userService.createAdmin(admin);
		}
		
	}
}
