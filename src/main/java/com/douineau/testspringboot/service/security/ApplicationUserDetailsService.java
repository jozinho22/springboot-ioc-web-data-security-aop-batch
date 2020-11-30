package com.douineau.testspringboot.service.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.security.ApplicationUserDetailsDao;
import com.douineau.testspringboot.security.ApplicationUserDetails;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
	
	private ApplicationUserDetailsDao repo;

//	@Autowired
//	public ApplicationUserDetailsService(@Qualifier("fakeDao") ApplicationUserDetailsDao auddRepo) {
//		super();
//		this.repo = auddRepo;
//	}
	
	@Autowired
	public ApplicationUserDetailsService(@Qualifier("fakeDao") ApplicationUserDetailsDao auddRepo) {
		super();
		this.repo = auddRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
//		Optional<User> user = repo.findByName(username);
		Optional<ApplicationUserDetails> appUserDetails = repo.findUserDetailsByUsername(username);
		if(!appUserDetails.isPresent()) {
			throw new UsernameNotFoundException("Ce username n'existe pas : " + username);
		}
		
		return appUserDetails.get();
	}

}
