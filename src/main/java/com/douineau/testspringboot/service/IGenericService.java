package com.douineau.testspringboot.service;

import java.util.List;
import java.util.Set;

public interface IGenericService<T> {
		
	T getObject(Integer id);
	
	List<T> getAllObjects();
	
	String addObject(T object);
	
	String addObjects(Set<T> objects);

}
