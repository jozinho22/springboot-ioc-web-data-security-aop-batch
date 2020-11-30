package com.douineau.testspringboot.controller.security;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.controller.GenericAdminController;
import com.douineau.testspringboot.model.security.Role;
import com.douineau.testspringboot.service.security.RoleService;

@RestController
@RequestMapping("admin/roles")
public class RoleController implements GenericAdminController<Role>  {
	
	@Autowired
	private RoleService service;
	
	@Override
	public Role getObject(Integer id) {
		return service.getObject(id);
	}
	
	@Override
	public List<Role> getAllObjects() {
		return service.getAllObjects();
	}

	@Override
	public String addObjects(Set<Role> objects) {
		service.addObjects(objects);;
		return  "Roles insérés";
	}
	
}
