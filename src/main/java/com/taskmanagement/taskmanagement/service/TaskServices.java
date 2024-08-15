package com.taskmanagement.taskmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taskmanagement.taskmanagement.model.Task;

@Service
public interface TaskServices {
	public Task addTask(Task c);
	
	
//	public Task updateTask(long Id, Task c);
	

	public String deleteTask(Long id);
	
	
	public List<Task> getAllTask();
	
	
	

	
	public Task getTask(Long id);


	public Task updateTask(Long Id, Task c);


	public List<Task> listAll(String keyword);


	

	
	

	
	

}
