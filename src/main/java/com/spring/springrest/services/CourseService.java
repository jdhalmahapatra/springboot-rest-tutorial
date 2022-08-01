package com.spring.springrest.services;

import java.util.List;
import java.util.Optional;

import com.spring.springrest.entity.Course;

public interface CourseService {
	public List<Course> getAllCourse();
	public Optional<Course> getCourseById(long id);
	public Course createCourse(Course course);
	public Course updateCourse(Course course);
	public void deleteCourse(long id);
}
