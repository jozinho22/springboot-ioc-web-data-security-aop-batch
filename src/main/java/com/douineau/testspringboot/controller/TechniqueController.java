package com.douineau.testspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.model.Technique;
import com.douineau.testspringboot.service.TechniqueService;

@RestController
@RequestMapping("/techniques")
public class TechniqueController implements GenericController<Technique>  {
	
	@Autowired
	private TechniqueService service;

	@Override
	public List<Technique> getAllObjects() {
		return service.getAllObjects();
	}

	@Override
	public String addObjects(List<Technique> disciples) {
		service.addObjects(disciples);
		return "Techiques insérées";
	}
	
	
}
