package com.douineau.model.security;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.douineau.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role extends AbstractEntity {

	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<User> users;

	public Role() {
		super();
	}
	
	public Role(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return super.toString() + " - [users=" + users + "]";
	}

}
