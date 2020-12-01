package com.douineau.testspringboot.service;

import java.util.Set;

public interface IGenericAdminService<T> extends IGenericService<T> {
	
	public String addObjects(Set<T> objects);

}
