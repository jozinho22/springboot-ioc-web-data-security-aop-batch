package com.douineau.testspringboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface GenericController<T> {

	@GetMapping("/{id}")
	public T getObject(@PathVariable("id") Integer id);
	
	@GetMapping
	public List<T> getAllObjects();
	
	@PostMapping
	public String addObjects(@RequestBody List<T> objects);
	
}
