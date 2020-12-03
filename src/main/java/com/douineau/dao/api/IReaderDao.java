package com.douineau.dao.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.model.api.Reader;

@Repository
public interface IReaderDao extends CrudRepository<Reader, Integer> {

}
