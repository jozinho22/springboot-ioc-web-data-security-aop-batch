package com.douineau.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douineau.model.api.Book;
import com.douineau.model.api.Reader;
import com.douineau.model.api.Writer;

@Configuration
public class ApiMappingConfig {
	
	@Bean("apiMapping")
	public Map<String, Class<?>> apiMapping() {
		
		Map<String, Class<?>> mapping = new HashMap<String, Class<?>>();
		mapping.put("/api/books", Book.class);
		mapping.put("/api/readers", Reader.class);
		mapping.put("/api/writers", Writer.class);
		
		return mapping;
	}

}
