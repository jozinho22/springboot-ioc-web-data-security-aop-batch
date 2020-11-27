package com.douineau.testspringboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.testspringboot.model.Person;

@Repository
public interface PersonDao extends CrudRepository<Person, Integer> {

}
