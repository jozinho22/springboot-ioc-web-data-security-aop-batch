package com.douineau.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.douineau.service.IGenericService;

public class GenericController<T> implements IGenericController<T> {

	@Autowired
	protected IGenericService<T> service;

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

	@Override
	public String addObject(T object) {
		return service.addObject(object);
	}
	
}
