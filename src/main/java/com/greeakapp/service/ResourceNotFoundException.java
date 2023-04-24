package com.greeakapp.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ResponseStatus(HttpStatus.NOT_FOUND)
@RestControllerAdvice
public class ResourceNotFoundException extends RuntimeException {

	
	public ResourceNotFoundException(String string, HttpStatus notFound) {
		
	}

	public ResourceNotFoundException(String string, Long id) {
		
	}

}
