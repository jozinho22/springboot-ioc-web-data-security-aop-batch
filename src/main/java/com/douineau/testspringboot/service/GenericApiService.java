package com.douineau.testspringboot.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public interface GenericApiService<T> extends GenericService<T> {

	void addObjects(List<T> objects);

}
