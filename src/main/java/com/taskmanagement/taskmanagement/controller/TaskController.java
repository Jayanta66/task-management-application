package com.taskmanagement.taskmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.taskmanagement.exception.NoDataException;
import com.taskmanagement.taskmanagement.exception.TaskNotFoundException;
import com.taskmanagement.taskmanagement.exception.TaskNotFoundExceptionNow;
import com.taskmanagement.taskmanagement.model.Task;
import com.taskmanagement.taskmanagement.repository.TaskRepository;

@RestController
@CrossOrigin("http://localhost:3000")
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping("/")
	public String home() {
		return "Welcome to The Task Management Application";
	}
	
	@PostMapping("/api/tasks")
	public ResponseEntity<?> addTask(@RequestBody Task task){
		Task tas = taskRepository.save(task);
			return new ResponseEntity<>(task,HttpStatus.CREATED);
	}
	
	@GetMapping("/api/tasks")
	public ResponseEntity<?> getTask() throws NoDataException{
		List<Task> list = taskRepository.findAll();
		if((!list.isEmpty()))
			return new ResponseEntity<>(list,HttpStatus.OK);
		else
			throw new NoDataException("No Data Found");
	}
    
    
    @GetMapping("/api/tasks/{id}")
    Optional<Task> getTaskById(@PathVariable Long id) {
    	return taskRepository.findById(id);
    	
    }
	
  
    @PutMapping("/api/tasks/{id}")
	public Task updateTask(@RequestBody Task newTask, @PathVariable("id") long id) throws TaskNotFoundException{
    	return taskRepository.findById(id)
    			.map(task ->{
    				task.setTitle(newTask.getTitle());
    				task.setDescription(newTask.getDescription());
    				task.setStatus(newTask.getStatus());
    				task.setCreatedAt(newTask.getCreatedAt());
    				task.setUpdatedAt(newTask.getUpdatedAt());
    				return taskRepository.save(task);
    			}).orElseThrow( () -> new TaskNotFoundExceptionNow(id));
    }    
    
    @DeleteMapping("/api/tasks/{id}")
    String deleteTask(@PathVariable Long id) {
    	if(!taskRepository.existsById(id)) {
    		throw new TaskNotFoundExceptionNow(id);
    	}
    	taskRepository.deleteById(id);
    	return "Task ID deleted Successfully";
    }
    
}
