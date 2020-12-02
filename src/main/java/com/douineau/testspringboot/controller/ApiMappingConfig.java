package com.douineau.testspringboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douineau.testspringboot.model.api.Book;
import com.douineau.testspringboot.model.api.Reader;
import com.douineau.testspringboot.model.api.Writer;

@Configuration
public class ApiMappingConfig {
	
	@Bean("apiMapping")
	public Map<String, Class<?>> mapping() {
		
		Map<String, Class<?>> mapping = new HashMap<String, Class<?>>();
		mapping.put("/api/books", Book.class);
		mapping.put("/api/readers", Reader.class);
		mapping.put("/api/writers", Writer.class);
		
		return mapping;
	}

}
