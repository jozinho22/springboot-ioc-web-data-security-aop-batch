package com.douineau.testspringboot.service;

import java.util.List;

public interface IGenericApiService<T> extends IGenericService<T> {
	
	public String addObjects(List<T> objects);

}
