package com.douineau.testspringboot.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IGenericAdminController<T> extends IGenericController<T> {
	
	@PostMapping
	public String addObjects(@RequestBody Set<T> objects);
	
}
