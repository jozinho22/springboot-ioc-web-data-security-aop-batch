package com.douineau.testspringboot.controller.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.douineau.testspringboot.service.api.IGenericApiService;
import com.douineau.testspringboot.util.ApiUtil;

/**
 * Attention à bien respecter le nommage des API commme la norme le veut
 * Remplir le fichier ApiMappingConfig pour la généricité
 * @author josselin.douineau
 *
 * @param <T>
 */
public class GenericApiController<T> implements IGenericApiController<T> {

	@Autowired
	@Qualifier("api")
	protected IGenericApiService<T> service;
	
	@Autowired
	private Map<String, Class<?>> apiMapping;

	@Override
	public T getObject(HttpServletRequest request, Integer id) {
		return service.getObject(ApiUtil.getType(request, apiMapping), id);
	}

	@Override
	public List<T> getAllObjects(HttpServletRequest request) {
		return service.getAllObjects(ApiUtil.getType(request, apiMapping));
	}

	@Override
	public String addObjects(HttpServletRequest request, Set<T> objects) {
		return service.addObjects(ApiUtil.getType(request, apiMapping), objects);		
	}

	@Override
	public String addObject(HttpServletRequest request, T object) {
		return service.addObject(ApiUtil.getType(request, apiMapping), object);
	}
	
}
