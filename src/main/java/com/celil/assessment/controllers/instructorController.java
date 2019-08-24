package com.celil.assessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.celil.assessment.models.Course;
import com.celil.assessment.models.instructor;
import com.celil.assessment.services.CourseService;
import com.celil.assessment.services.InstructorService;

@RestController
@RequestMapping("/instructor")
public class instructorController {
	
	// inject the service object
	@Autowired
	InstructorService inst_service;
	
	
	
	// the method takes a class object sent from the client side
	// it then forwards this object to its service and returns the service response as a JSON object.
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public instructor saveCourse(instructor inst) {
		inst_service.saveInst(inst);
		
		return inst;
	}
	
	// the method takes the class object id from client side
	// it then forwards the id to the service, and return what ever the service returns as a JSON object. 
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public instructor getInst(
			@PathVariable("id") int inst_id) {
		
		instructor inst = inst_service.getInstructor(inst_id);
				
		return inst;
	}
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<instructor> getAllInstructors(){
		List<instructor> instructors = inst_service.getAllInstructors();
		return instructors;
		
	}

}
