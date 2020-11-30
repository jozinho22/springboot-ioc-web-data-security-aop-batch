package com.douineau.testspringboot.security.enums;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

public enum ApplicationRole {

	ADMIN(Sets.newHashSet(ApplicationPermission.WRITE)), 
	USER(Sets.newHashSet(ApplicationPermission.READ, ApplicationPermission.WRITE));
	
	private Set<ApplicationPermission> permissions;

	public Set<ApplicationPermission> getPermissions() {
		return permissions;
	}

	private ApplicationRole(Set<ApplicationPermission> permissions) {
		this.permissions = permissions;
	}
	
	public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
		 Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
			.map(permission -> new SimpleGrantedAuthority(permission.name()))
			.collect(Collectors.toSet());
		 
		 permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		 
		return permissions;
	}


}
