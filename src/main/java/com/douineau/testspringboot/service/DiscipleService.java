package com.douineau.testspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.DiscipleDao;
import com.douineau.testspringboot.model.Disciple;

@Service
public class DiscipleService implements GenericService<Disciple> {
	
	@Autowired 
	private DiscipleDao repo;

	@Override
	public List<Disciple> getAllObjects() {
		return (List<Disciple>) repo.findAll();
	}

	@Override
	public void addObjects(List<Disciple> objects) {
		repo.saveAll(objects);
	}

}
