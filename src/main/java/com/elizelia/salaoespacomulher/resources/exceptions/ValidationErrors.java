package com.elizelia.salaoespacomulher.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrors extends StandardErrors{
	
	private List<FieldMessage> errors = new ArrayList<>();
			
	public ValidationErrors() {
		super();
	}

	public ValidationErrors(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
	}

	public ValidationErrors(List<FieldMessage> errors) {
		super();
		this.errors = errors;
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}
	
	
	
}
