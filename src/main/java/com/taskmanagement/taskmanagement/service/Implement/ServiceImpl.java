package com.taskmanagement.taskmanagement.service.Implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanagement.taskmanagement.model.Task;
import com.taskmanagement.taskmanagement.repository.TaskRepository;
import com.taskmanagement.taskmanagement.service.TaskServices;

@Service
public class ServiceImpl implements TaskServices {
	@Autowired
	TaskRepository repo;
	


	@Override
	public Task addTask(Task c) {
		if(c!=null) {
		//	repo1.save(e.getAddress());
			return repo.save(c);
		}
		else		
		return null;
	}



	@Override
	public Task updateTask(Long Id, Task c) {
		Task cus = null;
		Optional ac=repo.findById(Id);
		if(ac.isPresent()) {
			cus=(Task) ac.get();
			cus.setId(Id);
			cus.setTitle(c.getTitle());
			cus.setDescription(c.getDescription());
			cus.setStatus(c.getStatus());
			cus.setUpdatedAt(c.getUpdatedAt());
			cus.setCreatedAt(c.getCreatedAt());
		    return	repo.save(cus);		
		}	
		else
		return null;
	}

	@Override
	public String deleteTask(Long id) {
		Optional emp=repo.findById(id);
		if(emp.isPresent()) {
			repo.delete((Task) emp.get());
			return "Deleted";
		}
		else

		return null;
	}


	@Override
	public List<Task> getAllTask() {
		return repo.findAll();
	}




	@Override
	public Task getTask(Long id) {
		Optional cus=repo.findById(id);
		if(cus.isPresent())
			return (Task) cus.get();
		
		else	
			return null;
	}








	@Override
	public List<Task> listAll(String keyword) {
		if (keyword != null) {
			return repo.search(keyword);
		}
		return repo.findAll();
	}
	
	


}
