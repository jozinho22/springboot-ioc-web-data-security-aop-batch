package com.douineau.testspringboot.service.api;

import java.util.List;
import java.util.Set;

public interface IGenericApiService<T> {
		
	T getObject(Class<?> clazz, Integer id);
	
	List<T> getAllObjects(Class<?> clazz);
	
	String addObjects(Class<?> clazz, Set<T> objects);
	
	String addObject(Class<?> clazz, T object);

}
