package com.taskmanagement.taskmanagement.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.cache.spi.UpdateTimestampsCache;

@Entity
@Table(name="task")
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	String title ;
	
	String description ;
	String status ;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt")
	Date createdAt ;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedAt")
	Date updatedAt ;

	public Task() {
		super();
	}


	public Task(Long id, String title, String description, String status, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	
	public Task(String title, String description, String status, Date createdAt, Date updatedAt) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	
	

	public Task(Long id, String title, String description, String status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
	}

	
	

	public Task(String title, String description, String status) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}




	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}


}

