package com.celil.assessment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celil.assessment.models.ClassRoom;
import com.celil.assessment.models.Course;
import com.celil.assessment.repositories.CourseRepository;

@Service
public class CourseService {
	
	// inject the classRoom repository
	@Autowired
	CourseRepository course_repo;
	
	// the method takes a class object sent from the controller side
	// it then saves this object to its repository and returns the object.
	public void saveCourse(Course course) {
		
		course_repo.save(course);
		
		System.out.println( course + "has been saved!");
		
	}
	
	// the method takes the class object id from controller side
	// it then queries the database using the class repository object
	// it returns the class object if found, if not found it returns an empty, new instantiated class object.
	public Course getCourse(int course_id) {
		
		Course course = course_repo.findById(course_id).orElse(new Course());
		System.out.println(course.getName() +" course is being fetched!");
		
		return course;
	}
	
	// returns all the classRoom objects in the database.
	public List<Course> getAllCourses(){
		List<Course> courses = (List<Course>) course_repo.findAll();
		
		System.out.println("courses are being fetched!");
		
		return courses;
		
		
	}
	

}
