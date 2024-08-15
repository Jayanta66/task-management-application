package com.taskmanagement.taskmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taskmanagement.taskmanagement.model.Task;

//@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

//	String save(Long i);

	@Query("SELECT t FROM Task t WHERE t.title = :title")
	public Task getTitle(String title);
	
//	Optional<Task> findTaskById(long id);
	
	@Query("SELECT t FROM Task t WHERE CONCAT(t.id, ' ',t.title, ' ', t.description, ' ', t.status, ' ', t.createdAt,' ', t.updatedAt) LIKE %?1%")
	public List<Task> search(String keyword);

}
