package com.douineau.testspringboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.testspringboot.model.Technique;

@Repository
public interface TechniqueDao extends CrudRepository<Technique, Integer> {

}
