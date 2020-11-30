package com.douineau.testspringboot.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public interface IGenericApiService<T> extends IGenericService<T> {

	void addObjects(List<T> objects);

}
