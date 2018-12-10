package com.ens.courseApi.CourseApi.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	private int internalCode;
	private String shortDescrption;
	private String Description;
	public int getInternalCode() {
		return internalCode;
	}
	public void setInternalCode(int internalCode) {
		this.internalCode = internalCode;
	}
	public String getShortDescrption() {
		return shortDescrption;
	}
	public void setShortDescrption(String shortDescrption) {
		this.shortDescrption = shortDescrption;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public UserNotFoundException(int internalCode, String shortDescrption, String description) {
		super();
		this.internalCode = internalCode;
		this.shortDescrption = shortDescrption;
		Description = description;
	}
	public UserNotFoundException() {
		super();
	}

	
	
}
