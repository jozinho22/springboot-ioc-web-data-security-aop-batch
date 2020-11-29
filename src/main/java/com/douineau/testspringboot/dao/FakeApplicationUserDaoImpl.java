package com.douineau.testspringboot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.douineau.testspringboot.dao.security.ApplicationUserDetailsDao;
import com.douineau.testspringboot.security.ApplicationUserDetails;
import com.douineau.testspringboot.security.enums.ApplicationRole;
import com.google.common.collect.Lists;

@Repository("fakeDao")
public class FakeApplicationUserDaoImpl implements ApplicationUserDetailsDao {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Optional<ApplicationUserDetails> findUserDetailsByUsername(String username) {
		return getApplicationUserDetails()
				.stream()
				.filter(applicationUser -> applicationUser.getUsername().equals(username))
				.findFirst();
	}

	private List<ApplicationUserDetails> getApplicationUserDetails() {
		 
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLES_" + ApplicationRole.ADMIN.name()));
		
		
		ApplicationUserDetails appUserDetails = new ApplicationUserDetails(
				"Joss",
				passwordEncoder.encode("joss"),
				true,
				true,
				true,
				true,
				authorities
				);
		
		List<ApplicationUserDetails> userDetails = Lists.newArrayList(
				appUserDetails
				);
		
		return userDetails;
	}
}
