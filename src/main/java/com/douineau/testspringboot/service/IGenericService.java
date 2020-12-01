package com.douineau.testspringboot.service;

import java.util.List;

public interface IGenericService<T> {
		
	public T getObject(Integer id);
	
	public List<T> getAllObjects();

}
