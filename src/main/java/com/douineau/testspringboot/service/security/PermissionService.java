package com.douineau.testspringboot.service.security;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.security.PermissionDao;
import com.douineau.testspringboot.model.security.Permission;
import com.douineau.testspringboot.service.GenericAdminService;

@Service
public class PermissionService implements GenericAdminService<Permission> {
	
	@Autowired
	private PermissionDao repo;

	@Override
	public Permission getObject(Integer id) {
		return repo.findById(id).get();
	}
	
	@Override
	public List<Permission> getAllObjects() {
		return (List<Permission>) repo.findAll();
	}

	@Override
	public void addObjects(Set<Permission> objects) {
		repo.saveAll(objects);
	}


}
