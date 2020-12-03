package com.douineau.testspringboot.security.jwt;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;

	private final JwtConfig jwtConfig;
	
	@Autowired
	public JwtAuthenticationFilter(AuthenticationManager authenticationManager,
			JwtConfig jwtConfig) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtConfig = jwtConfig;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		System.out.println("Tentative d'authentification");
		System.out.println("Requête depuis un client : : " + request.getMethod() + " - " +  request.getRequestURI());
		Authentication authentication = null;
		try {
			JwtAuthenticationRequest upaRequest = new ObjectMapper().readValue(request.getInputStream(),
					JwtAuthenticationRequest.class);

			authentication = new UsernamePasswordAuthenticationToken(upaRequest.getUsername(),
					upaRequest.getPassword());

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return authenticationManager.authenticate(authentication);
	}
	
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		
		System.out.println("Authentification ratée");
		super.unsuccessfulAuthentication(request, response, failed);
	}
	
	@Override
	protected void successfulAuthentication(
			HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		System.out.println("Authentification réussie");

		String token = Jwts.builder()
			.setSubject(authResult.getName())
			.claim(
					"authorities", 
					authResult.getAuthorities())
			.setIssuedAt(new Date())
			.setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(
					jwtConfig.getTokenExpirationAfterDays()))
					)
			.signWith(jwtConfig.getSecretKeyForSigning())	
			.compact();
		
		response.setHeader(
				jwtConfig.getAuthorizationHeader(), 
				jwtConfig.getTokenPrefix() + token);	
		
		System.out.println("Token envoyé dans le Header : " + token);
		
		super.successfulAuthentication(request, response, chain, authResult);
	}

}
