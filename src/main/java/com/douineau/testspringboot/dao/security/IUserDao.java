package com.douineau.testspringboot.dao.security;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.testspringboot.model.security.User;

@Repository
public interface IUserDao extends CrudRepository<User, Integer> {

	Optional<User> findByName(String name);

}
