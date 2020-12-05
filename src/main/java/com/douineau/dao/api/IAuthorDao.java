package com.douineau.dao.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.model.api.Author;

@Repository
public interface IAuthorDao extends CrudRepository<Author, Integer> {

}
