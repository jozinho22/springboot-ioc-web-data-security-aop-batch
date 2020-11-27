package com.douineau.testspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.PersonDao;
import com.douineau.testspringboot.model.Person;

@Service
public class PersonService {
	
	@Autowired 
	private PersonDao repo;
	
	public List<Person> getPersons() {
		return (List<Person>) repo.findAll();
	}

	public void addPersons(List<Person> persons) {
		repo.saveAll(persons);
	}
}
