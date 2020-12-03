package com.douineau.dao.security;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.model.security.Permission;

@Repository
public interface IPermissionDao extends CrudRepository<Permission, Integer> {

	Optional<Permission> findByName(String name);
}
