package com.douineau.controller.security;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.controller.GenericController;
import com.douineau.model.security.User;

@RestController
@RequestMapping("admin/users")
public class UserController extends GenericController<User> {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String addObjects(Set<User> objects) {
		
		for(User user : objects) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
		}
		return service.addObjects(objects);
		
	}

}
