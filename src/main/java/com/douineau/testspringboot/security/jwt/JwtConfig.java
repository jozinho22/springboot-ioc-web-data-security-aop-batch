package com.douineau.testspringboot.security.jwt;

import javax.crypto.SecretKey;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.net.HttpHeaders;

import io.jsonwebtoken.security.Keys;

@Configuration
@ConfigurationProperties(prefix = "application.jwt")
public class JwtConfig {
	
	private String signingSecretKey;
	private String tokenPrefix;
	private Integer tokenExpirationAfterDays;
	
	public JwtConfig() {
		super();
	}

	public String getSigningSecretKey() {
		return signingSecretKey;
	}

	public void setSigningSecretKey(String signingSecretKey) {
		this.signingSecretKey = signingSecretKey;
	}

	public String getTokenPrefix() {
		return tokenPrefix;
	}

	public void setTokenPrefix(String tokenPrefix) {
		this.tokenPrefix = tokenPrefix;
	}

	public Integer getTokenExpirationAfterDays() {
		return tokenExpirationAfterDays;
	}

	public void setTokenExpirationAfterDays(Integer tokenExpirationAfterDays) {
		this.tokenExpirationAfterDays = tokenExpirationAfterDays;
	}

	@Bean
	public SecretKey getSecretKeyForSigning() {
		return Keys.hmacShaKeyFor(signingSecretKey.getBytes());
	}
	
	public String getAuthorizationHeader() {
		return HttpHeaders.AUTHORIZATION;
	}
	
}
