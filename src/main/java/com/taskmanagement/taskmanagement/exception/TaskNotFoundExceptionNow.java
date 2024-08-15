package com.taskmanagement.taskmanagement.exception;
/* Created by Arjun Gautam */

public class TaskNotFoundExceptionNow extends RuntimeException{
    public TaskNotFoundExceptionNow(Long id){
        super("Could not found the Task with id "+ id);
    }
}
