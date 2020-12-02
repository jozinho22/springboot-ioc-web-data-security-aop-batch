package com.douineau.testspringboot.service.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.IGenericDao;

@Service("api")
public class GenericApiService<T> implements IGenericApiService<T> {

	@Autowired
	private IGenericDao<T> repo;
	
	@Override
	public T getObject(Class<?> clazz, Integer id) {
		return repo.getObject(clazz, id);
	}

	@Override
	public List<T> getAllObjects(Class<?> clazz) {
		return repo.getAllObjects(clazz);
	}
	
	@Override
	public String addObject(Class<?> clazz, T object) {
		repo.addObject(clazz, object);
		return "Objet de type : " + object.getClass().getTypeName() + " bien inséré (API générique)";
	}

	@Override
	public String addObjects(Class<?> clazz, Set<T> objects) {
		repo.addObjects(clazz, objects);
		return "Objets de type : " + objects.getClass().getTypeName() + " bien insérés (API générique)";
	}



}
