package com.douineau.testspringboot.dao.security;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.testspringboot.model.security.Permission;

@Repository
public interface IPermissionDao extends CrudRepository<Permission, Integer> {

	Optional<Permission> findByName(String name);
}
