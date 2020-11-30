package com.douineau.testspringboot.model.security;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import com.douineau.testspringboot.model.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Permission extends AbstractEntity {
	
	@ManyToMany(mappedBy = "permissions", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<User> users;
	
	public Permission() {
		super();
	}

	public Permission(String name) {
		super();
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
