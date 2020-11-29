package com.douineau.testspringboot.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.controller.GenericController;
import com.douineau.testspringboot.model.api.Technique;
import com.douineau.testspringboot.service.api.TechniqueService;

@RestController
@RequestMapping("api/techniques")
public class TechniqueController implements GenericController<Technique>  {
	
	@Autowired
	private TechniqueService service;

	@Override
	public Technique getObject(Integer id) {
		return service.getObject(id);
	}
	
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
