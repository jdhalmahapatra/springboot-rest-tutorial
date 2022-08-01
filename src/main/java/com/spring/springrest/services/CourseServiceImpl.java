package com.spring.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springrest.dao.CourseDao;
import com.spring.springrest.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	//The initial version is demonstrated using inMemory data store. 
	//We have not implemented any Database configuration while creating the REST API version
	//I am keeping this as commented for reference. 
	//As I am going to integrate DB, so I am only Commenting instead of removing.
	
	
	//private List<Course> courseList;
	
	
	//Configuring Database using Spring Data JPA
	
	@Autowired
	private CourseDao courseDao;
	
	
	
	
	public CourseServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
//		courseList = new ArrayList<Course>();
//		courseList.add(new Course(
//				45, 
//				"Core Java", 
//				"It is one of the most used programming language", 
//				3
//		));
//		courseList.add(new Course(
//				46, 
//				"Spring Core", 
//				"It is the most important framework in Java", 
//				3
//		));
		
	}



	@Override
	public List<Course> getAllCourse() {
		return this.courseDao.findAll();
		//return courseList;
	}



	@Override
	public Optional<Course> getCourseById(long id) {
//		for(Course course: courseList) {
//			if(id == course.getId()) {
//				return course;
//			}
//			else continue;
//		}
		return this.courseDao.findById(id);
	}



	@Override
	public Course createCourse(Course course) {
//		if(this.courseList == null)
//			this.courseList = new ArrayList<Course>();
//
//		this.courseList.add(course);
		this.courseDao.save(course);
		return course;
	}



	@Override
	public Course updateCourse(Course course) {		
//		this.courseList.forEach(c -> {
//			if(c.getId() == course.getId()) {
//				c.setTitle(course.getTitle());
//				c.setDescription(course.getDescription());
//				c.setDuration(course.getDuration());
//			}
//		});
		this.courseDao.save(course);
		return course;
	}



	@Override
	public void deleteCourse(long id) {
		//this.courseList = this.courseList.stream().filter(e -> e.getId() != id).collect(Collectors.toList());
		Optional<Course> course = this.courseDao.findById(id);
		
		if(course != null)
			this.courseDao.deleteById(id);
	}
	
	
}
