package com.douineau.testspringboot.model.api;

import javax.persistence.Entity;

import com.douineau.testspringboot.model.AbstractEntity;

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
