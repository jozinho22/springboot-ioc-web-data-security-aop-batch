package com.douineau.controller.api;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IGenericApiController<T> {
	
	@GetMapping("/{id}")
	public T getObject(HttpServletRequest request, @PathVariable("id") Integer id);
	
	@GetMapping
	public List<T> getAllObjects(HttpServletRequest request);
	
//	@PostMapping
	public String addObject(HttpServletRequest request, @RequestBody T object);
	
	@PostMapping
	public String addObjects(HttpServletRequest request, @RequestBody Set<T> objects);

}
