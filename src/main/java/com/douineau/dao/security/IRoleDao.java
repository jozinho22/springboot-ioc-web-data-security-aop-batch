package com.douineau.dao.security;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.model.security.Permission;
import com.douineau.model.security.Role;

@Repository
public interface IRoleDao extends CrudRepository<Role, Integer> {

	Optional<Role> findByName(String name);
}
