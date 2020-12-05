package com.douineau.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:database.properties")
public class ExternalizedDatabaseConfig {
	
	@Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;

}
