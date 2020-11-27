package com.douineau.testspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douineau.testspringboot.model.Laptop;
import com.douineau.testspringboot.service.LaptopService;

@RestController
@RequestMapping("/laptops")
public class LaptopController {
	
	@Autowired
	private LaptopService service;
	
	@GetMapping
	public List<Laptop> getLaptops() {			
		return service.getLaptops();
				
	}
	
	@PostMapping
	public String addLaptops(@RequestBody List<Laptop> laptops) {
		service.addLaptops(laptops);
		return "Laptops insérées";
				
	}

}
