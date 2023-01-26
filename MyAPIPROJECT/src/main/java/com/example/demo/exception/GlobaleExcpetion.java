package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@RestControllerAdvice
public class GlobaleExcpetion {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiofMessage> ResourceNotFoundException(ResourceNotFoundException web) {
		String messag = web.getMessage();
		ApiofMessage api = new ApiofMessage(messag, true);
		return new ResponseEntity<ApiofMessage>(api, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handeler(MethodArgumentNotValidException mx) {

		Map<String, String> map = new HashMap<>();

		mx.getBindingResult().getAllErrors().forEach((error) -> {

			String fe = ((FieldError) error).getField();

			String defaultMessage = error.getDefaultMessage();

			map.put(fe, defaultMessage);
		});

		return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ApiofMessage> MethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ma) {
		String message = ma.getMessage();
	    ApiofMessage api1 = new ApiofMessage(message,false);
	    api1.setMessage("There is no Contoller for This method");
	    api1.setField(false);
		return new ResponseEntity<ApiofMessage>(api1,HttpStatus.BAD_REQUEST);
		
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ApiofMessage> MethodMismatch(HttpRequestMethodNotSupportedException ma) {
		String message = ma.getMessage();
	    ApiofMessage api1 = new ApiofMessage(message,false);
	    api1.setMessage("You Chose Wrong API");
	    api1.setField(false);
		return new ResponseEntity<ApiofMessage>(api1,HttpStatus.BAD_REQUEST);
		
	}
}






