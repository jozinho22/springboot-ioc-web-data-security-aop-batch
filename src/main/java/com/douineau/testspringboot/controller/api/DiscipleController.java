package com.douineau.testspringboot.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.controller.GenericController;
import com.douineau.testspringboot.model.api.Disciple;
import com.douineau.testspringboot.service.api.DiscipleService;

@RestController
@RequestMapping("api/disciples")
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
