package com.taskmanagement.taskmanagement.exception;

public class TaskNotFoundException extends Exception {

	String msg;

	public TaskNotFoundException(String msg) {
		super("Could not found the Task with id ");
		this.msg = msg;
	}
	
	
	

}
