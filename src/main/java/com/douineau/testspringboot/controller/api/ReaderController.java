package com.douineau.testspringboot.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.controller.IGenericApiController;
import com.douineau.testspringboot.model.api.Reader;
import com.douineau.testspringboot.service.api.ReaderService;

@RestController
@RequestMapping("api/readers")
public class ReaderController implements IGenericApiController<Reader> {
	
	@Autowired
	private ReaderService service;

	@Override
	public Reader getObject(Integer id) {
		return service.getObject(id);
	}
	
	@Override
	public List<Reader> getAllObjects() {
		return service.getAllObjects();
	}

	@Override
	public String addObjects(List<Reader> objects) {
		service.addObjects(objects);
		return "Lecteurs insérés";
	}

}
