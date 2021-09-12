package com.elizelia.salaoespacomulher.service.exceptions;

public class DataIntegrityViolationException extends RuntimeException{
	private static final long serialVersionUID = -1102796966713384501L;

	public DataIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegrityViolationException(String message) {
		super(message);
	}
	
	
}
