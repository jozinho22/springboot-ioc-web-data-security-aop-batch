package com.douineau.testspringboot.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public interface IGenericService<T> {

	T getObject(Integer id); 
	
	List<T> getAllObjects();

}
