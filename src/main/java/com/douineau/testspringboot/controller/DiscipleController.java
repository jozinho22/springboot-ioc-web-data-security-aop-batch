package com.douineau.testspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.model.Disciple;
import com.douineau.testspringboot.service.DiscipleService;

@RestController
@RequestMapping("/disciples")
public class DiscipleController implements GenericController<Disciple> {
	
	@Autowired
	private DiscipleService service;

	@Override
	public List<Disciple> getAllObjects() {
		return service.getAllObjects();
	}

	@Override
	public String addObjects(List<Disciple> objects) {
		service.addObjects(objects);
		return "Disciples insérées";
	}

}
