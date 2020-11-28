package com.douineau.testspringboot.dao.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.testspringboot.model.security.Authority;

@Repository
public interface AuthorityDao extends CrudRepository<Authority, Integer> {

}
