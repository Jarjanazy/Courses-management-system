package com.celil.assessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.celil.assessment.models.ClassRoom;
import com.celil.assessment.models.Course;
import com.celil.assessment.repositories.CourseRepository;
import com.celil.assessment.services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	// inject the service object
	@Autowired
	CourseService course_service;
	
	
	
	// the method takes a class object sent from the client side
	// it then forwards this object to its service and returns the service response as a JSON object.
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public Course saveCourse(Course course) {
		course_service.saveCourse(course);
		
		return course;
	}
	
	// the method takes the class object id from client side
	// it then forwards the id to the service, and return what ever the service returns as a JSON object. 
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Course getCourse(
			@PathVariable("id") int course_id) {
		
		Course course = course_service.getCourse(course_id);
				
		return course;
	}
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Course> getAllCourses(){
		List<Course> courses = course_service.getAllCourses();
		return courses;
		
	}
	
	
	
	

}
