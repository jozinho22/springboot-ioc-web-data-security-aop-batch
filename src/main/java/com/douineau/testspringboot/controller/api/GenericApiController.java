package com.douineau.testspringboot.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.douineau.testspringboot.controller.IGenericApiController;
import com.douineau.testspringboot.service.IGenericApiService;

public class GenericApiController<T> implements IGenericApiController<T> {

	@Autowired
	protected IGenericApiService<T> service;

	@Override
	public T getObject(Integer id) {
		return service.getObject(id);
	}

	@Override
	public List<T> getAllObjects() {
		return service.getAllObjects();
	}

	@Override
	public String addObjects(List<T> objects) {
		return service.addObjects(objects);		
	}
	
}
