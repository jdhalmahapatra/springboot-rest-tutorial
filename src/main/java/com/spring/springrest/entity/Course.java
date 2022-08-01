package com.spring.springrest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {
	
	@Id
	private long id;
	private String title;
	private String description;
	private int duration;
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Course(long id, String title, String description, int duration) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.duration = duration;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
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


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", description=" + description + ", duration=" + duration
				+ "]";
	}
	
	
	
}
