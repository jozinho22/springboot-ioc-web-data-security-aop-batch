package com.douineau.testspringboot.dao;

import java.util.List;
import java.util.Set;

public interface IGenericDao<T> {
	
	T getObject(Class<?> clazz, Integer id);

	List<T> getAllObjects(Class<?> clazz);
	
	void addObject(Class<?> clazz, T object);
	
	void addObjects(Class<?> clazz, Set<T> objects);

}
