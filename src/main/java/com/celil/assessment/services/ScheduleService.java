package com.celil.assessment.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.celil.assessment.models.ClassRoom;
import com.celil.assessment.models.Course;
import com.celil.assessment.models.Schedule;
import com.celil.assessment.models.Slot;
import com.celil.assessment.models.instructor;
import com.celil.assessment.models.DTO.ScheduleDTO;
import com.celil.assessment.repositories.ClassRoomRepository;
import com.celil.assessment.repositories.CourseRepository;
import com.celil.assessment.repositories.ScheduleRepository;
import com.celil.assessment.repositories.SlotRepository;
import com.celil.assessment.repositories.instructorRepository;

@Service
public class ScheduleService {
	
	// inject the repositories of the entities we want to check.
	@Autowired
	ScheduleRepository schedule_repo;
	
	@Autowired
	SlotRepository slot_repo;
	
	@Autowired
	ClassRoomRepository classRoom_repo;
	
	@Autowired
	instructorRepository inst_repo;
	
	@Autowired
	CourseRepository course_repo;
	
	
	
	
	
	// the method takes the IDs of (slot, course, classRoom, instructor) from the controller side
	// it then checks its integrity, 
	//if it passes the integrity test, the schedule is saved to its repository and returned from the method.
	// if it didn't pass the test a Schedule object with null values is returned.
	public ScheduleDTO saveSchedule(int slot_id
			,int course_id,
			int classRoom_id,
			int instructor_id) {
		
		// first, get all schedules
		List<Schedule> schedules = (List<Schedule>) schedule_repo.findAll();
		
		// for each schedule, we check its data against the new coming schedule data
		for (Schedule schedule: schedules) {
			// check if the schedules clash in slot, classRoom
			if (schedule.getSchedule_slot().getId() == slot_id && 
					schedule.getSchedule_classRoom().getId() == classRoom_id)
			{
				System.out.println("The schedule you are trying to add clashes with another schedule.");
				System.out.println("Please check the slot, classRoom availablity");
				// return without saving anything.
				return new ScheduleDTO();
				
			}
			
			// check if an instructor is being placed in two places at once.
			if (schedule.getSchedule_slot().getId() == slot_id &&
					schedule.getSchedule_instructor().getId() == instructor_id) {
				System.out.println("The schedule you are trying to add doesn't apply with the instructor's program.");
				// return without saving anything.
				return new ScheduleDTO();
				
			}			
		}
		
		// The schedule passed the integrity tests, and ready to be saved into the database.
		
		// get the objects
		Slot slot = slot_repo.findById(slot_id).orElse(null);
		ClassRoom classRoom = classRoom_repo.findById(classRoom_id).orElse(null);
		instructor inst = inst_repo.findById(instructor_id).orElse(null);
		Course course = course_repo.findById(course_id).orElse(null);
		
		// check if any of the objects doesn't exists
		if (slot != null && classRoom != null 
				&& inst != null && course != null) {
			// the objects exist
			Schedule schedule = new Schedule(course, classRoom, inst, slot);
			ScheduleDTO scheduleDTO = new ScheduleDTO(course.getName(), classRoom.getName(), inst.getName(), slot.getId());
			
			//save the schedule object
			schedule_repo.save(schedule);
			System.out.println( schedule + "has been saved!");
			
			return scheduleDTO;
		}
		// one, or more, of the objects doesn't exist
		else {
			return new ScheduleDTO();
		}
		
	}
	
	
	public ScheduleDTO getSchedule(int schedule_id) {
		
		Schedule schedule = schedule_repo.findById(schedule_id).orElse(null);
		
		if (schedule != null)
		{
			ScheduleDTO scheduleDTO = new ScheduleDTO(schedule.getSchedule_course().getName(), 
					schedule.getSchedule_classRoom().getName(),
					schedule.getSchedule_instructor().getName(),
					schedule.getSchedule_slot().getId());
			
			return scheduleDTO;
		}
		else {
			return new ScheduleDTO();
		}
	}
	
	// returns all the classRoom objects in the database.
	//TODO convert all the schedules to schedulDTOs
	public List<ScheduleDTO> getAllSchedules(){
		List<Schedule> schedules = (List<Schedule>) schedule_repo.findAll();
		List<ScheduleDTO> schedulesDTO = new ArrayList<ScheduleDTO>();
		// convert to DTOs
		
		for (Schedule schedule : schedules) {
			schedulesDTO.add(
					new ScheduleDTO(schedule.getSchedule_course().getName(),
							schedule.getSchedule_classRoom().getName(),
							schedule.getSchedule_instructor().getName(),
							schedule.getSchedule_slot().getId())
					);
		}
		
		System.out.println("schedules are being fetched!");
		
		return schedulesDTO;
		
		
	}

}
