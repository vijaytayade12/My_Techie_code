package com.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import com.userservice.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResouceNotFoundException.class)
	public ResponseEntity<String> handlerResourceNotFoundException(ResouceNotFoundException rnfe) {

		String message = rnfe.getMessage();
		// ApiResponse responce =
		// ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);

	}

}
