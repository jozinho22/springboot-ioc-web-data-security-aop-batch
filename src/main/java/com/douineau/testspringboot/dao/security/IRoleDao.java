package com.douineau.testspringboot.dao.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.testspringboot.model.security.Role;

@Repository
public interface IRoleDao extends CrudRepository<Role, Integer> {

}
