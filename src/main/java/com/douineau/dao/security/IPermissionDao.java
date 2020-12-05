package com.douineau.dao.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.model.security.Permission;

@Repository
public interface IPermissionDao extends CrudRepository<Permission, Integer> {

}
