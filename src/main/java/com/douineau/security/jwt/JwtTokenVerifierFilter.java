package com.douineau.security.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.common.base.Strings;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

public class JwtTokenVerifierFilter extends OncePerRequestFilter {

	private final JwtConfig jwtConfig;
	
	@Autowired
	public JwtTokenVerifierFilter(JwtConfig jwtConfig) {
		super();
		this.jwtConfig = jwtConfig;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		System.out.println("Requête depuis un client : " + request.getMethod() + " - " +  request.getRequestURI());
		
		String authorizationHeader = request.getHeader(jwtConfig.getAuthorizationHeader());
		if(Strings.isNullOrEmpty(authorizationHeader) 
				|| !authorizationHeader.startsWith(jwtConfig.getTokenPrefix())) {
			filterChain.doFilter(request, response);
			return;
		}
		String token = null;
		
		try {
		    token = authorizationHeader.replace(jwtConfig.getTokenPrefix(), "");
			
			@SuppressWarnings("deprecation")
			Jws<Claims> claimJws = Jwts
				.parser()
				.setSigningKey(jwtConfig.getSecretKeyForSigning())
				.parseClaimsJws(token);
			Claims body = claimJws.getBody();
			String username = body.getSubject();
			
			List<Map<String, String>> authorities = (List<Map<String, String>>) body.get("authorities");
			Set<SimpleGrantedAuthority> grantedAuthorities = 
					authorities.stream()
					.map(m -> new SimpleGrantedAuthority(m.get("authority")))
					.collect(Collectors.toSet());
			
			Authentication authentication = new UsernamePasswordAuthenticationToken
					(username,
					null,
					grantedAuthorities);
			
			if(authentication.isAuthenticated())
				System.out.println("Bien authentifié sous le username " + username);
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			filterChain.doFilter(request, response);
		} catch(JwtException e) {
			throw new IllegalStateException(String.format("can not be trusted", token));
		}
		
	}

}
