package com.douineau.testspringboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.testspringboot.model.Disciple;

@Repository
public interface DiscipleDao extends CrudRepository<Disciple, Integer> {

}
