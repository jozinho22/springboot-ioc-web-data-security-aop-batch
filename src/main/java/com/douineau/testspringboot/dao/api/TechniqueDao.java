package com.douineau.testspringboot.dao.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.testspringboot.model.api.Technique;

@Repository
public interface TechniqueDao extends CrudRepository<Technique, Integer> {

}
