package com.douineau.testspringboot.service.security;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.security.UserDao;
import com.douineau.testspringboot.model.security.User;
import com.douineau.testspringboot.service.GenericAdminService;

@Service
public class UserService implements GenericAdminService<User> {
	
	@Autowired
	private UserDao repo;

	@Override
	public User getObject(Integer id) {
		return repo.findById(id).get();
	}
	
	@Override
	public List<User> getAllObjects() {
		return (List<User>) repo.findAll();
	}

	@Override
	public void addObjects(Set<User> objects) {
		repo.saveAll(objects);
	}

}
