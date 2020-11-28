package com.douineau.testspringboot.service.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.security.AuthorityDao;
import com.douineau.testspringboot.model.security.Authority;
import com.douineau.testspringboot.service.GenericService;

@Service
public class AuthorityService implements GenericService<Authority>{
	
	@Autowired
	private AuthorityDao repo;

	@Override
	public List<Authority> getAllObjects() {
		return (List<Authority>) repo.findAll();
	}

	@Override
	public void addObjects(List<Authority> objects) {
		repo.saveAll(objects);
	}


}
