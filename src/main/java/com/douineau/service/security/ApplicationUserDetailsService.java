package com.douineau.service.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.douineau.dao.security.IApplicationUserDetailsDao;
import com.douineau.security.ApplicationUserDetails;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
	
	private IApplicationUserDetailsDao auddRepo;

//	@Autowired
//	public ApplicationUserDetailsService(@Qualifier("fakeDao") ApplicationUserDetailsDao auddRepo) {
//		super();
//		this.repo = auddRepo;
//	}
	
	@Autowired
	public ApplicationUserDetailsService(@Qualifier("realDao") IApplicationUserDetailsDao auddRepo) {
		super();
		this.auddRepo = auddRepo;
	}

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
