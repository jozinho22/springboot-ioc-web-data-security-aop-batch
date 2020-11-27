package com.douineau.testspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.LaptopDao;
import com.douineau.testspringboot.model.Laptop;

@Service
public class LaptopService {
	
	@Autowired 
	private LaptopDao repo;
	
	public List<Laptop> getLaptops() {
		return (List<Laptop>) repo.findAll();
	}

	public void addLaptops(List<Laptop> laptops) {
		repo.saveAll(laptops);
	}

}
