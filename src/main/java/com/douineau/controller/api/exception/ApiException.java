package com.douineau.controller.api.exception;

import org.springframework.http.HttpStatus;

public class ApiException {
	
	private final String message;
	private final HttpStatus status;
	
	public ApiException(String message, HttpStatus status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	public HttpStatus getStatus() {
		return status;
	}

}
