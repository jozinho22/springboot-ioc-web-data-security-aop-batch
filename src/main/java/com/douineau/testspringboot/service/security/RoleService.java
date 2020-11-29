package com.douineau.testspringboot.service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.security.RoleDao;
import com.douineau.testspringboot.model.security.Role;
import com.douineau.testspringboot.service.GenericService;

@Service
public class RoleService implements GenericService<Role> {
	
	@Autowired
	private RoleDao repo;

	@Override
	public List<Role> getAllObjects() {
		return (List<Role>) repo.findAll();
	}

	@Override
	public void addObjects(List<Role> objects) {
		repo.saveAll(objects);
	}


}
