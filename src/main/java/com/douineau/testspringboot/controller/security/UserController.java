package com.douineau.testspringboot.controller.security;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.controller.IGenericAdminController;
import com.douineau.testspringboot.model.security.User;
import com.douineau.testspringboot.service.security.UserService;

@RestController
@RequestMapping("admin/users")
public class UserController implements IGenericAdminController<User>  {
	
	@Autowired
	private UserService service;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User getObject(Integer id) {
		return service.getObject(id);
	}
	
	@Override
	public List<User> getAllObjects() {
		return service.getAllObjects();
	}

	@Override
	public String addObjects(Set<User> objects) {
		
		for(User user : objects) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		service.addObjects(objects);
		
		return "User insérés avec encoding du password";
	}
	
}
