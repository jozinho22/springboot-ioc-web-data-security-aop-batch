package com.douineau.testspringboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douineau.testspringboot.model.Laptop;

@Repository
public interface LaptopDao extends CrudRepository<Laptop, Integer> {

}
