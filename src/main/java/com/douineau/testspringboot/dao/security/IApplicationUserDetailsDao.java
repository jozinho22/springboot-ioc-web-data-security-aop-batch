package com.douineau.testspringboot.dao.security;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.douineau.testspringboot.security.ApplicationUserDetails;

@Repository
public interface IApplicationUserDetailsDao {

	Optional<ApplicationUserDetails> findUserDetailsByUsername(String username);

}
