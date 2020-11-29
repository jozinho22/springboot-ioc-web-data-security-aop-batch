package com.douineau.testspringboot.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.api.DiscipleDao;
import com.douineau.testspringboot.model.api.Disciple;
import com.douineau.testspringboot.service.GenericService;

@Service
public class DiscipleService implements GenericService<Disciple> {
	
	@Autowired 
	private DiscipleDao repo;

	@Override
	public Disciple getObject(Integer id) {
		return repo.findById(id).get();
	}
	
	@Override
	public List<Disciple> getAllObjects() {
		return (List<Disciple>) repo.findAll();
	}

	@Override
	public void addObjects(List<Disciple> objects) {
		repo.saveAll(objects);
	}
}
