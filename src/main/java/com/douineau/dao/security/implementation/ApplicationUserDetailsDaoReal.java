package com.douineau.dao.security.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.douineau.dao.security.IApplicationUserDetailsDao;
import com.douineau.dao.security.IUserDao;
import com.douineau.model.security.Permission;
import com.douineau.model.security.Role;
import com.douineau.model.security.User;
import com.douineau.security.ApplicationUserDetails;

@Repository("realDao")
public class ApplicationUserDetailsDaoReal implements IApplicationUserDetailsDao {

	private final IUserDao repo;
	
	@Autowired
	public ApplicationUserDetailsDaoReal(PasswordEncoder passwordEncoder,
			IUserDao repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Optional<ApplicationUserDetails> findUserDetailsByUsername(String username) {
		
		ApplicationUserDetails appUserDetails = null;
		Optional<User> userMayBe = repo.findByName(username);
		if(userMayBe.isPresent()) {
			
			User u = userMayBe.get();
			List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
			for(Role role : u.getRoles()) {
				authorities.add(new SimpleGrantedAuthority(role.getName()));
			}
			for(Permission permission : u.getPermissions()) {
				authorities.add(new SimpleGrantedAuthority(permission.getName()));
			}
			
			appUserDetails = new ApplicationUserDetails(
					u.getName(),
					u.getPassword(),
					u.isAccountNonExpired(),
					u.isAccountNonLocked(),
					u.isCredentialsNonExpired(),
					u.isEnabled(),
					authorities
					);
		} else {
			return Optional.empty();
		}
		
		return Optional.of(appUserDetails);
	}
	
}
