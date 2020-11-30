package com.douineau.testspringboot.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.api.ReaderDao;
import com.douineau.testspringboot.model.api.Reader;
import com.douineau.testspringboot.service.GenericApiService;

@Service
public class ReaderService implements GenericApiService<Reader> {
	
	@Autowired 
	private ReaderDao repo;

	@Override
	public Reader getObject(Integer id) {
		return repo.findById(id).get();
	}
	
	@Override
	public List<Reader> getAllObjects() {
		return (List<Reader>) repo.findAll();
	}

	@Override
	public void addObjects(List<Reader> objects) {
		repo.saveAll(objects);
	}
}
