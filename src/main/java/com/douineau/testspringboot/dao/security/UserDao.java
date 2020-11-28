package com.douineau.testspringboot.dao.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.testspringboot.model.security.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	User findByName(String name);
}
