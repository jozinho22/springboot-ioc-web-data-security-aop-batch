package com.douineau.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:db.properties")
public class ExternalizedDatabaseConfig {
	
	@Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;

}
