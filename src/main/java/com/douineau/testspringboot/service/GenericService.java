package com.douineau.testspringboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface GenericService<T> {

	public List<T> getAllObjects();

	public void addObjects(List<T> objects);

}
