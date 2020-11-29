package com.douineau.testspringboot.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class ApplicationUserDetails extends User implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6881969431236214232L;
	
	public ApplicationUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
	
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return super.getAuthorities();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}
	
	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		return super.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return super.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return super.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return super.isEnabled();
	}

}
