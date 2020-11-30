package com.douineau.testspringboot.dao.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.testspringboot.model.security.Permission;

@Repository
public interface PermissionDao extends CrudRepository<Permission, Integer> {

}
