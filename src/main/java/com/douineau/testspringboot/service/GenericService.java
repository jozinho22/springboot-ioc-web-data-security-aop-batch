package com.douineau.testspringboot.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.IGenericDao;

@Service
public class GenericService<T> implements IGenericService<T> {

	@Autowired
	private IGenericDao<T> repo;
	
	@Override
	public T getObject(Integer id) {
		return null;
	}

	@Override
	public List<T> getAllObjects() {
		return null;
	}

	@Override
	public String addObjects(Set<T> objects) {
		return null;
	}

	@Override
	public String addObject(T object) {
		return null;
	}

}
