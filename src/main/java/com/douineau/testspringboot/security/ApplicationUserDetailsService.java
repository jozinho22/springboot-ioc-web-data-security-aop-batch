package com.douineau.testspringboot.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.douineau.testspringboot.dao.security.ApplicationUserDetailsDao;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
	
//	@Autowired
//	private UserDao repo;
	
	@Autowired
	@Qualifier("fakeDao")
	private ApplicationUserDetailsDao auddRepo;

//	public ApplicationUserDetailsService(ApplicationUserDetailsDao auddRepo) {
//		super();
//		this.auddRepo = auddRepo;
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
//		Optional<User> user = repo.findByName(username);
		Optional<ApplicationUserDetails> appUserDetails = auddRepo.findUserDetailsByUsername(username);
		if(!appUserDetails.isPresent()) {
			throw new UsernameNotFoundException("Ce username n'existe pas : " + username);
		}
		
		return appUserDetails.get();
	}

}
