package com.douineau.testspringboot.controller.security;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.douineau.testspringboot.controller.IGenericAdminController;
import com.douineau.testspringboot.service.IGenericAdminService;

public class GenericAdminController<T> implements IGenericAdminController<T> {

	@Autowired
	protected IGenericAdminService<T> service;

	@Override
	public T getObject(Integer id) {
		return service.getObject(id);
	}

	@Override
	public List<T> getAllObjects() {
		return service.getAllObjects();
	}
	
	@Override
	public String addObjects(Set<T> objects) {
		 return service.addObjects(objects);
	}
	
}
