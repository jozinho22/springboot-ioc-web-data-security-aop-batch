package com.douineau.dao.security;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.douineau.security.ApplicationUserDetails;

@Repository
public interface IApplicationUserDetailsDao {

	Optional<ApplicationUserDetails> findUserDetailsByUsername(String username);

}
