package com.douineau.controller.api;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.douineau.controller.api.exception.ApiException;
import com.douineau.controller.api.exception.ApiNoContentException;
import com.douineau.service.api.IGenericApiService;
import com.douineau.util.ApiUtil;

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
		T object = service.getObject(ApiUtil.getType(request, apiMapping), id);
		if(object == null) {
			throw new ApiNoContentException("Aucune donnée présente");
		}
		return object;
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
