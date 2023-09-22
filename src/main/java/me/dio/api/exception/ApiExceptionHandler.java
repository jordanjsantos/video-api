package me.dio.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import me.dio.domain.exception.EntityNotFoundException;

@RestControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleEntityNotFoundException(EntityNotFoundException ex) {
		return ex.getMessage();
	}
		
}
