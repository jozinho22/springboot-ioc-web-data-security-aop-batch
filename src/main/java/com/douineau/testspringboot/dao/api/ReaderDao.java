package com.douineau.testspringboot.dao.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.testspringboot.model.api.Reader;

@Repository
public interface ReaderDao extends CrudRepository<Reader, Integer> {

}
