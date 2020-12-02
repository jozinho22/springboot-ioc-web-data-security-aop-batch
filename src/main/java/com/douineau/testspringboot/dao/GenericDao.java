package com.douineau.testspringboot.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GenericDao<T> implements IGenericDao<T> {
	
	@PersistenceContext(name = "test_sb_pu")
	private EntityManager manager;
	
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public T getObject(Class<?> clazz, Integer id) {
		return (T) getManager().find(clazz, id);
	}

	@Override
	public List<T> getAllObjects(Class<?> clazz) {
//		String query = "FROM " + clazz.getSimpleName();
		String query = "FROM " + clazz.getSimpleName() + " t";
		System.out.println("query = " + query);
		System.out.println("getManager().createQuery(query).getResultList() = " + getManager().createQuery(query).getResultList());
		return (List<T>) getManager().createQuery(query, clazz).getResultList();
	}

	@Override
	@Transactional
	public void addObject(Class<?> clazz, T object) {
		getManager().persist(object);
	}

	@Override
	@Transactional
	public void addObjects(Class<?> clazz, Set<T> objects) {
		for(T object : objects) {
			getManager().persist(object);
		}
	}

}
