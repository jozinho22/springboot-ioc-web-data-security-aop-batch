package com.douineau.testspringboot.dao.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.testspringboot.model.api.Writer;

@Repository
public interface IWriterDao extends CrudRepository<Writer, Integer> {

}
