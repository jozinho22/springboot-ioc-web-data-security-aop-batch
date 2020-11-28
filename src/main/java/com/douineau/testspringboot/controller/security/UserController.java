package com.douineau.testspringboot.controller.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.controller.GenericController;
import com.douineau.testspringboot.model.security.User;
import com.douineau.testspringboot.service.security.UserService;

@RestController
@RequestMapping("/users")
public class UserController implements GenericController<User>  {
	
	@Autowired
	private UserService service;

	@Override
	public List<User> getAllObjects() {
		return service.getAllObjects();
	}

	@Override
	public String addObjects(List<User> objects) {
		service.addObjects(objects);;
		return  "User insérées";
	}
	
}
