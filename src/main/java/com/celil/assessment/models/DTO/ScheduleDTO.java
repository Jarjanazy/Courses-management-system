package com.celil.assessment.models.DTO;

import com.celil.assessment.models.ClassRoom;
import com.celil.assessment.models.Course;
import com.celil.assessment.models.Slot;
import com.celil.assessment.models.instructor;

// this class is used to carry a Schedule object information, not as objects of their classes (ClassRoom, Course, Instructor)
// but as simple integer and String values
// it's used because two-way binding is used within the objects, and returning them as JSON is causing infinite loops.
public class ScheduleDTO {
	
	private String schedule_course_name;
	private String schedule_classRoom_name;
	private String schedule_instructor_name;
	private int schedule_slot_id;
	
	
	public String getSchedule_course_name() {
		return schedule_course_name;
	}
	public void setSchedule_course_name(String schedule_course_name) {
		this.schedule_course_name = schedule_course_name;
	}
	public String getSchedule_classRoom_name() {
		return schedule_classRoom_name;
	}
	public void setSchedule_classRoom_name(String schedule_classRoom_name) {
		this.schedule_classRoom_name = schedule_classRoom_name;
	}
	public String getSchedule_instructor_name() {
		return schedule_instructor_name;
	}
	public void setSchedule_instructor_name(String schedule_instructor_name) {
		this.schedule_instructor_name = schedule_instructor_name;
	}
	public int getSchedule_slot_id() {
		return schedule_slot_id;
	}
	public void setSchedule_slot_id(int schedule_slot_id) {
		this.schedule_slot_id = schedule_slot_id;
	}
	public ScheduleDTO( 
			String schedule_course_name,
			String schedule_classRoom_name,
			String schedule_instructor_name, 
			int schedule_slot_id) {
		
		super();
		this.schedule_course_name = schedule_course_name;
		this.schedule_classRoom_name = schedule_classRoom_name;
		this.schedule_instructor_name = schedule_instructor_name;
		this.schedule_slot_id = schedule_slot_id;
	}
	public ScheduleDTO() {
		super();
	}
	
	

}
