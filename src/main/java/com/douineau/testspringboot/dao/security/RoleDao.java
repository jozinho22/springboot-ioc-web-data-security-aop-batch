package com.douineau.testspringboot.dao.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.testspringboot.model.security.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, Integer> {

}
