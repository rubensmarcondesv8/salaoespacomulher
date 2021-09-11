package com.elizelia.salaoespacomulher.service.exceptions;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -6918182829971246658L;

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundException(String message) {
		super(message);
	}

}
