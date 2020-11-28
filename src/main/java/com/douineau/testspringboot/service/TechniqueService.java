package com.douineau.testspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.TechniqueDao;
import com.douineau.testspringboot.model.Technique;

@Service
public class TechniqueService implements GenericService<Technique> {
	
	@Autowired 
	private TechniqueDao repo;

	@Override
	public List<Technique> getAllObjects() {
		return (List<Technique>) repo.findAll();
	}

	@Override
	public void addObjects(List<Technique> objects) {
		repo.saveAll(objects);
	}
	
//	public List<Technique> getT {
//		return (List<Technique>) repo.findAll();
//	}
//
//	public void addLaptops(List<Technique> laptops) {
//		repo.saveAll(laptops);
//	}

}
