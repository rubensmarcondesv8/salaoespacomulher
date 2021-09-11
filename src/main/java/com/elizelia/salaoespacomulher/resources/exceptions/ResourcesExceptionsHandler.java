package com.elizelia.salaoespacomulher.resources.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourcesExceptionsHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardErrors> objectNotFoundException(ObjectNotFoundException e, ServletRequest request){
		StandardErrors error = new StandardErrors(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);		
	}

}
