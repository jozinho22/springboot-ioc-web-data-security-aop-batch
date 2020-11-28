//package com.douineau.testspringboot.security;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.douineau.testspringboot.model.security.Authority;
//import com.douineau.testspringboot.model.security.User;
//
//public class MyUserDetails implements UserDetails {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -5081026142075183901L;
//	
//	@Autowired
//	private User user;
//
//	public MyUserDetails(User user) {
//		super();
//		this.user = user;
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
////		return Collections.singleton(new SimpleGrantedAuthority("USER"));
//		
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		for(Authority auth : user.getAuthorities()) {
//			authorities.add(new SimpleGrantedAuthority(auth.getRole()));
//		}
//		
//		return authorities;
//	}
//
//	@Override
//	public String getUsername() {
//		return user.getName();
//	}
//	
//	@Override
//	public String getPassword() {
//		return user.getPassword();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return user.isAccountNonExpired();
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return user.isAccountNonLocked();
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return user.isCredentialsNonExpired();
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return user.isEnabled();
//	}
//
//}
