package com.douineau.testspringboot.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Person extends AbstractEntity {

	private String name;
	@OneToMany
	@JoinColumn(name = "person_id")
	private List<Laptop> laptops;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Laptop> getLaptops() {
		return laptops;
	}

	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}

	@Override
	public String toString() {
		return "Person [id=" + super.getId() + ", name=" + name + ", /n laptops=" + laptops + "]";
	}

}
