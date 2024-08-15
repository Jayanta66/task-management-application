package com.taskmanagement.taskmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class NoDataException extends Exception {
	
	String msg;

	public NoDataException(String msg) {
		super();
		this.msg = msg;
	}
	
	

}
