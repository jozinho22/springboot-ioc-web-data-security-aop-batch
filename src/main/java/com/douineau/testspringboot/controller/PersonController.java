package com.douineau.testspringboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.model.Person;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@GetMapping
	public List<Person> getPersons() {
		List<Person> persons = new ArrayList<Person>();
		Person p1 = new Person();
		p1.setName("Joss");
		p1.setUuid(UUID.randomUUID());
		Person p2 = new Person();
		p2.setName("Alex");
		p2.setUuid(UUID.randomUUID());
		persons.add(p1);
		persons.add(p2);
		
		System.out.println("Dans l'API");
		
		return persons;
				
	}

}
