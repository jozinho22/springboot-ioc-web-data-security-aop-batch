package com.douineau.testspringboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.model.Person;
import com.douineau.testspringboot.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@GetMapping
	public List<Person> getPersons() {			
		return service.getPersons();
				
	}
	
	@PostMapping
	public String addPersons(@RequestBody List<Person> persons) {
		service.addPersons(persons);
		return "Personnes insérées";
				
	}

}
