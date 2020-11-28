package com.douineau.testspringboot.model;

import javax.persistence.Entity;

@Entity
public class Technique extends AbstractEntity {
	
	private String name;
	
	public Technique() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Technique [name=" + name + "]";
	}


}
