package com.spring.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springrest.entity.Course;
import com.spring.springrest.services.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/api/course")
	public List<Course> getAllCourse(){
		return this.courseService.getAllCourse();
	}
	
	@GetMapping("/api/course/{courseId}")
	public Optional<Course> getCourseById(@PathVariable long courseId) {
		return this.courseService.getCourseById(courseId);
	}
	
	@PostMapping(path= "/api/course", consumes="application/json")
	public Course createNewCourse(@RequestBody Course course) {
		return this.courseService.createCourse(course);
	}
	
	//@RequestMapping(path="/api/course", method= RequestMethod.PUT)
	@PutMapping(path="/api/course", consumes="application/json")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
	@DeleteMapping("/api/course/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable long courseId){
		try {
			this.courseService.deleteCourse(courseId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception exp) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
		
	
}
