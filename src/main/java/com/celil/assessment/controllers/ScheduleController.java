package com.celil.assessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.celil.assessment.models.Course;
import com.celil.assessment.models.Schedule;
import com.celil.assessment.models.DTO.ScheduleDTO;
import com.celil.assessment.services.CourseService;
import com.celil.assessment.services.ScheduleService;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
	
	// inject the service object for Schedule
	@Autowired
	ScheduleService schedule_service;
	
	
	
	// the method takes a four parameters from the client request
	// corresponding slot_id, course_id, classroom_id, instructor_id
	// it then forwards those parameters to its service and returns the service response as a JSON object.
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ScheduleDTO saveSchedule(int slot_id
			,int course_id,
			int classRoom_id,
			int instructor_id) {
		
		System.out.println("in the saveSchedule with "+ slot_id+ " "+ course_id+ " "+ classRoom_id +" "+ instructor_id);
		
		
		ScheduleDTO schedule = schedule_service.saveSchedule(slot_id, course_id, classRoom_id, instructor_id);
		return schedule;
	}
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ScheduleDTO getSchedule(
			@PathVariable("id") int schedule_id) {
		
		ScheduleDTO schedule = schedule_service.getSchedule(schedule_id);
				
		return schedule;
	}
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<ScheduleDTO> getAllSchedules(){
		List<ScheduleDTO> schedules = schedule_service.getAllSchedules();
		return schedules;
		
	}
		
	
	

}
