package com.douineau.testspringboot.controller.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.controller.GenericController;
import com.douineau.testspringboot.model.security.Role;
import com.douineau.testspringboot.service.security.RoleService;

@RestController
@RequestMapping("admin/roles")
public class RoleController implements GenericController<Role>  {
	
	@Autowired
	private RoleService service;

	@Override
	public List<Role> getAllObjects() {
		return service.getAllObjects();
	}

	@Override
	public String addObjects(List<Role> objects) {
		service.addObjects(objects);;
		return  "Roles insérés";
	}

	
	
}
