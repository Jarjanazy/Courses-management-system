package com.celil.assessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.celil.assessment.repositories.ClassRoomRepository;
import com.celil.assessment.services.ClassRoomServices;
import com.celil.assessment.models.ClassRoom;

@RestController
@RequestMapping("/classroom")
public class ClassRoomController {
	
	// inject the service object
	@Autowired
	ClassRoomServices classRoom_service;
	
	
	
	// the method takes a class object sent from the client side
	// it then forwards this object to its service and returns the service response as a JSON object.
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ClassRoom saveClass(ClassRoom classRoomObj) {
		classRoom_service.saveClassRoom(classRoomObj);
		
		return classRoomObj;
	}
	
	// the method takes the class object id from client side
	// it then forwards the id to the service, and return what ever the service returns as a JSON object. 
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ClassRoom getClassRoom(
			@PathVariable("id") int classRoom_id) {
		
		ClassRoom classRoomObj = classRoom_service.getClassRoom(classRoom_id);
				
		return classRoomObj;
	}
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<ClassRoom> getAllClassRooms(){
		List<ClassRoom> classRooms = classRoom_service.getAllClassRooms();
		return classRooms;
		
	}
	

}
