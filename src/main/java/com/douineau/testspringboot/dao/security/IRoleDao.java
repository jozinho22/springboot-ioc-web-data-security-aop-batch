package com.douineau.testspringboot.dao.security;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.testspringboot.model.security.Permission;
import com.douineau.testspringboot.model.security.Role;

@Repository
public interface IRoleDao extends CrudRepository<Role, Integer> {

	Optional<Role> findByName(String name);
}
