package com.douineau.testspringboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IGenericController<T> {
	
	@GetMapping("/{id}")
	public T getObject(@PathVariable("id") Integer id);
	
	@GetMapping
	public List<T> getAllObjects();
	
}
