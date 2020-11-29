package com.douineau.testspringboot.model.security;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.douineau.testspringboot.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role extends AbstractEntity {

	private String name;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<User> users;

	public Role() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [name=" + name + ", users=" + users + "]";
	}

}
