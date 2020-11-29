package com.douineau.testspringboot.model.api;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.douineau.testspringboot.model.AbstractEntity;

@Entity
public class Disciple extends AbstractEntity {

	private String name;
	@OneToMany
	@JoinColumn(name = "disciple_id")
	private List<Technique> techniques;
	
	public Disciple() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Technique> getTechniques() {
		return techniques;
	}

	public void setTechniques(List<Technique> techniques) {
		this.techniques = techniques;
	}

	@Override
	public String toString() {
		return "Disciple [name=" + name + ", techniques=" + techniques + "]";
	}

}
