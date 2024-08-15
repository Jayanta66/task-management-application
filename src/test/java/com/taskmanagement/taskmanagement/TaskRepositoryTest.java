package com.taskmanagement.taskmanagement;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.hibernate.cache.spi.UpdateTimestampsCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.annotation.Rollback;

import com.taskmanagement.taskmanagement.model.Task;
import com.taskmanagement.taskmanagement.repository.TaskRepository;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class TaskRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired	
	private TaskRepository taskRepository;
	
	@Test
	public void testCreateTask() {
		Date createdAt = new Date(); 
		Date updatedAt = new Date();
		Task task = new Task("Java Full Web Development","Java Develper","Completed",createdAt,updatedAt);	
		Task savedtask = taskRepository.save(task);
		System.out.println(task);
		assertThat(savedtask.getId()).isGreaterThan(0);
		
	}
	

	@Test
	public void testListAllTask() {
		Iterable<Task> listTasks = taskRepository.findAll();
		listTasks.forEach(task -> System.out.println(task));
	}
	
	@Test
	public void testGetTaskById() {
		Task task = taskRepository.findById((long) 42).get();
		System.out.println(task);
		assertThat(task).isNotNull();
	}
	
	@Test
	public void testUpdateTaskDetails() {
		Task task = taskRepository.findById((long) 42).get();
		task.setId((long)42);
		task.setTitle("Jayanta Halderrrrrrrrrrrrrrrrrrrrr");
		task.setDescription("dsfdsf");
		task.setStatus("Completed");		
		System.out.println(taskRepository.save(task));

	}
	
	@Test
	public void testDeleteTask() {
		Long taskId = (long) 44;
		taskRepository.deleteById(taskId);
		System.out.println("Deleted Successfully");

		
	}
	
	@Test
	public void testGetByTaskTitle() {
		String title = "Full Stack Java";
		Task task = taskRepository.getTitle(title);
		System.out.println(task);
		assertThat(task).isNotNull();
	}


}
