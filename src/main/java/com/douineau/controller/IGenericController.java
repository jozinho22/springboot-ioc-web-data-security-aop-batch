package com.douineau.controller;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IGenericController<T> {
	
	@GetMapping("/{id}")
	public T getObject(@PathVariable("id") Integer id);
	
	@GetMapping
	public List<T> getAllObjects();
	
//	@PostMapping
	public String addObject(@RequestBody T object);
	
	@PostMapping
	public String addObjects(@RequestBody Set<T> objects);

}
