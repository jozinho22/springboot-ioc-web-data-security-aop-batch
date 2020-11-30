package com.douineau.testspringboot.service.api;

import java.util.List;

import org.springframework.stereotype.Service;

import com.douineau.testspringboot.model.api.Writer;
import com.douineau.testspringboot.service.IGenericApiService;
import com.google.common.collect.Lists;

@Service
public class GenericApiService<T> implements IGenericApiService<T> {
	
//	@Autowired
//	private GenericApiDao<T> repo;
	
	public T getObject(Integer id) {
		Writer w = new Writer();
		w.setName("Joss" + id);
		return (T) w;
	}

	@Override
	public List<T> getAllObjects() {
		return (List<T>) Lists.newArrayList(new Writer());
	}

	@Override
	public void addObjects(List<T> objects) {
	}

}
