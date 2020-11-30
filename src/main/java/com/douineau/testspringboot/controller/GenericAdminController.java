package com.douineau.testspringboot.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface GenericAdminController<T> extends GenericController<T> {
	
	@PostMapping
	public String addObjects(@RequestBody Set<T> objects);
	
}
