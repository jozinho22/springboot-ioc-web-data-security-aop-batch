package com.douineau.testspringboot.service;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public interface GenericAdminService<T> extends GenericService<T> {

	void addObjects(Set<T> objects);

}
