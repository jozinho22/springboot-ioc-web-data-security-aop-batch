package com.douineau.testspringboot.model;

import java.util.UUID;

import javax.persistence.Entity;

@Entity
public class Laptop extends AbstractEntity {
	
	private String brand;
	
	public Laptop() {
		super();
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + super.getId() + ",brand=" + brand + "]";
	}

}
