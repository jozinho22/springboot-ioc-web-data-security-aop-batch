package com.douineau.testspringboot.controller.security;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.controller.GenericAdminController;
import com.douineau.testspringboot.model.security.Permission;
import com.douineau.testspringboot.service.security.PermissionService;

@RestController
@RequestMapping("admin/permissions")
public class PermissionController implements GenericAdminController<Permission>  {
	
	@Autowired
	private PermissionService service;
	
	@Override
	public Permission getObject(Integer id) {
		return service.getObject(id);
	}
	
	@Override
	public List<Permission> getAllObjects() {
		return service.getAllObjects();
	}

	@Override
	public String addObjects(Set<Permission> objects) {
		service.addObjects(objects);;
		return  "Permissions insérés";
	}

	
}
