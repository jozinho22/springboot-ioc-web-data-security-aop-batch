package com.douineau.testspringboot.service;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public interface IGenericAdminService<T> extends IGenericService<T> {

	void addObjects(Set<T> objects);

}
