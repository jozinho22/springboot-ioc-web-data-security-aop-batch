package com.douineau.testspringboot.dao.security;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.douineau.testspringboot.security.ApplicationUserDetails;
import com.douineau.testspringboot.security.enums.ApplicationRole;
import com.google.common.collect.Lists;

@Repository("fakeDao")
public class FakeApplicationUserDetailsDaoImpl implements ApplicationUserDetailsDao {

	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public FakeApplicationUserDetailsDaoImpl(PasswordEncoder passwordEncoder) {
		super();
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Optional<ApplicationUserDetails> findUserDetailsByUsername(String username) {
		return getApplicationUserDetails()
				.stream()
				.filter(applicationUser -> applicationUser.getUsername().equals(username))
				.findFirst();
	}

	private List<ApplicationUserDetails> getApplicationUserDetails() {
		 
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority("ROLE_" + ApplicationRole.ADMIN.name()));
		
		ApplicationUserDetails admin = new ApplicationUserDetails(
				"admin",
				passwordEncoder.encode("admin"),
				true,
				true,
				true,
				true,
				ApplicationRole.ADMIN.getGrantedAuthorities()
				);
		
		ApplicationUserDetails user = new ApplicationUserDetails(
				"user",
				passwordEncoder.encode("user"),
				true,
				true,
				true,
				true,
				ApplicationRole.USER.getGrantedAuthorities()
				);
		
		List<ApplicationUserDetails> userDetails = Lists.newArrayList(
				admin, user
				);
		
		return userDetails;
	}
}
