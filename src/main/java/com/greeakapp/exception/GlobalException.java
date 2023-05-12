package com.greeakapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalException extends RuntimeException {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception exception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
	}

	@ExceptionHandler(CartItemNotFoundException.class)
	public ResponseEntity<String> handleCartItemNotFoundException(CartItemNotFoundException exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}

	/*
	 * @ExceptionHandler({ StudentNotFoundException.class,
	 * ProgrammeNotFoundException.class, CartItemNotFoundException.class })
	 * //@ResponseStatus(HttpStatus.NOT_FOUND) public ResponseEntity<String>
	 * handleNotFoundException(Exception e) { return
	 * ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage()); }
	 */
}
