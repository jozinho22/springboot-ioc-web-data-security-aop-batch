package com.douineau.testspringboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface GenericApiController<T> extends GenericController<T> {

	@PostMapping
	public String addObjects(@RequestBody List<T> objects);
	
}
