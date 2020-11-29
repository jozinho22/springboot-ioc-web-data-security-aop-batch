package com.douineau.testspringboot.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.security.UserDao;
import com.douineau.testspringboot.model.security.User;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = repo.findByName(username);
		if(!user.isPresent()) {
			throw new UsernameNotFoundException("Ce username n'existe pas : " + username);
		}
		
		return new ApplicationUserDetails(user.get());
	}

}
