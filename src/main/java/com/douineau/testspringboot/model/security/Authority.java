package com.douineau.testspringboot.model.security;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.douineau.testspringboot.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Authority extends AbstractEntity {

	private String role;

	@ManyToMany(mappedBy = "authorities")
	@JsonIgnore
	private List<User> users;

	public Authority() {
		super();
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Authority [role=" + role + ", users=" + users + "]";
	}

}
