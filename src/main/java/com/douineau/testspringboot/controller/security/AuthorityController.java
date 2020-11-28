package com.douineau.testspringboot.controller.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.controller.GenericController;
import com.douineau.testspringboot.model.security.Authority;
import com.douineau.testspringboot.service.security.AuthorityService;

@RestController
@RequestMapping("/authorities")
public class AuthorityController implements GenericController<Authority>  {
	
	@Autowired
	private AuthorityService service;

	@Override
	public List<Authority> getAllObjects() {
		return service.getAllObjects();
	}

	@Override
	public String addObjects(List<Authority> objects) {
		service.addObjects(objects);;
		return  "Authorities insérées";
	}

	
	
}
