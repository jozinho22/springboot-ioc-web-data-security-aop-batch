package com.douineau.service.api;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.dao.IGenericDao;

@Service("api")
public class GenericApiService<T> implements IGenericApiService<T> {

	@Autowired
	private IGenericDao<T> dao;
	
	@Override
	public T getObject(Class<?> clazz, Integer id) {
		return dao.getObject(clazz, id);
	}

	@Override
	public List<T> getAllObjects(Class<?> clazz) {
		return dao.getAllObjects(clazz);
	}
	
	@Override
	public String addObject(Class<?> clazz, T object) {
		dao.addObject(clazz, object);
		return "Objet de type : " + object.getClass().getTypeName() + " bien inséré (API générique)";
	}

	@Override
	public String addObjects(Class<?> clazz, Set<T> objects) {
		dao.addObjects(clazz, objects);
		return "Objets de type : " + objects.getClass().getTypeName() + " bien insérés (API générique)";
	}



}
