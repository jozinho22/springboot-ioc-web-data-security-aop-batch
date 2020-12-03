package com.douineau.dao.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.model.api.Book;

@Repository
public interface IBookDao extends CrudRepository<Book, Integer> {

}
