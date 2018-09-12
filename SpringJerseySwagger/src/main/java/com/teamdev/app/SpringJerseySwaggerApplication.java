package com.teamdev.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.teamdev.app","com.teamdev.app.web.rest","com.teamdev.app.config"})
public class SpringJerseySwaggerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJerseySwaggerApplication.class, args);
	}
	
}
