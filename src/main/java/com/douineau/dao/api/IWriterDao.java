package com.douineau.dao.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.model.api.Writer;

@Repository
public interface IWriterDao extends CrudRepository<Writer, Integer> {

}
