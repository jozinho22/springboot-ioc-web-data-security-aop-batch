package com.douineau.testspringboot.service.security;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.security.RoleDao;
import com.douineau.testspringboot.model.security.Role;
import com.douineau.testspringboot.service.GenericAdminService;

@Service
public class RoleService implements GenericAdminService<Role> {
	
	@Autowired
	private RoleDao repo;

	@Override
	public Role getObject(Integer id) {
		return repo.findById(id).get();
	}
	
	@Override
	public List<Role> getAllObjects() {
		return (List<Role>) repo.findAll();
	}

	@Override
	public void addObjects(Set<Role> objects) {
		repo.saveAll(objects);
	}


}
