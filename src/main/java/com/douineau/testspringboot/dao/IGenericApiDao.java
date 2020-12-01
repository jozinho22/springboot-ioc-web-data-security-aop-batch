package com.douineau.testspringboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericApiDao<T> extends CrudRepository<T, Integer> {

}
