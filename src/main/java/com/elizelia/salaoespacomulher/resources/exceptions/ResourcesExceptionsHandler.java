package com.elizelia.salaoespacomulher.resources.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.elizelia.salaoespacomulher.service.exceptions.DataIntegrityViolationException;
import com.elizelia.salaoespacomulher.service.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourcesExceptionsHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardErrors> objectNotFoundException(ObjectNotFoundException e, ServletRequest request) {
		StandardErrors error = new StandardErrors(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardErrors> dataIntegrityViolationException(DataIntegrityViolationException e,
			ServletRequest request) {
		StandardErrors error = new StandardErrors(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardErrors> validationError(MethodArgumentNotValidException e,
			ServletRequest request) {
		ValidationErrors error = new ValidationErrors(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Erro no tamanho do campo ou campo vazio");
		for(FieldError x:e.getBindingResult().getFieldErrors()) {
			error.addErrors(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
