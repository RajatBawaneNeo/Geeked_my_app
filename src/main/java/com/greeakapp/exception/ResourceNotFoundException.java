package com.greeakapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ResponseStatus(HttpStatus.NOT_FOUND)
@RestControllerAdvice
public class ResourceNotFoundException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus status;

	/*public ResourceNotFoundException(String string) {
		super(string);
		
	}

	public ResourceNotFoundException(String string, HttpStatus notFound) {
		super();
		
	}

	public ResourceNotFoundException(String string, Long id) {
		super();
		// TODO Auto-generated constructor stub
	}

}
*/
	public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public ResourceNotFoundException(String string, Long id) {
		super(string);
	}

	public HttpStatus getStatus() {
        return status;
    }
}

	