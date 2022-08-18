package com.example.demo.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionResource {
	
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<StandardError> exception(ApiException e, HttpServletRequest request){
		StandardError err = new StandardError();
		err.setTime(LocalDateTime.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setError(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> exception(MethodArgumentNotValidException e, HttpServletRequest request){
		StandardError err = new StandardError();
		err.setTime(LocalDateTime.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setError(e.getMessage());
		err.setError(e.getBindingResult().getFieldErrors().toString());
		err.setPath(request.getRequestURI());
		
		//Obtem os erros de cada campo do BeanValidation
		for (FieldError f : e.getBindingResult().getFieldErrors()) {
			err.getFieldsErrros().put(f.getField(), f.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	

}
