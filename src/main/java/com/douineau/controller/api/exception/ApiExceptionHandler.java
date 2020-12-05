package com.douineau.controller.api.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(ApiNoContentException.class)
	private ResponseEntity<Object> handle(ApiNoContentException ex) {
		
		ApiException apiEx = new ApiException(
				ex.getMessage(), 
				HttpStatus.NO_CONTENT
				);
		
		 HttpHeaders responseHeaders = new HttpHeaders();
		    responseHeaders.set("Header pour le test !!!", 
		      "Yo test ok !!!");
				
		return ResponseEntity
				.status(HttpStatus.NO_CONTENT)
				.headers(responseHeaders)
				.body("sdjbfdbfjs");
//		return new ResponseEntity<>(apiEx, HttpStatus.NO_CONTENT);
		
	}
}
