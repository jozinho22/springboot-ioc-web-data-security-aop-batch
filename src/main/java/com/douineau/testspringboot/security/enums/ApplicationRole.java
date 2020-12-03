package com.douineau.testspringboot.security.enums;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

public enum ApplicationRole {

	ADMIN(Sets.newHashSet(ApplicationPermission.WRITE, ApplicationPermission.READ)), 
	USER(Sets.newHashSet(ApplicationPermission.READ));
	
	private Set<ApplicationPermission> permissions;

	public Set<ApplicationPermission> getPermissions() {
		return permissions;
	}

	private ApplicationRole(Set<ApplicationPermission> permissions) {
		this.permissions = permissions;
	}
	
	public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
		
		 Set<SimpleGrantedAuthority> authorities = getPermissions().stream()
				 	.map(a -> new SimpleGrantedAuthority(a.name()))
				 	.collect(Collectors.toSet());
		 
		 authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		 
		return authorities;
	}


}
