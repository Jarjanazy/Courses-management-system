package com.celil.assessment.models.DTO;

import com.celil.assessment.models.Slot;

public class SlotDTO {
	
	
	private int id;
	
	private Slot.Day course_day;
		
	// the time which the slot starts at (hour)
	private int course_begin_hour;
	
	// the time which the slot ends at (hour)
	private int course_end_hour;

	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Slot.Day getCourse_day() {
		return course_day;
	}

	public void setCourse_day(Slot.Day course_day) {
		this.course_day = course_day;
	}

	public int getCourse_begin_hour() {
		return course_begin_hour;
	}

	public void setCourse_begin_hour(int course_begin_hour) {
		this.course_begin_hour = course_begin_hour;
	}

	public int getCourse_end_hour() {
		return course_end_hour;
	}

	public void setCourse_end_hour(int course_end_hour) {
		this.course_end_hour = course_end_hour;
	}

	public SlotDTO(int id, Slot.Day course_day, int course_begin_hour, int course_end_hour) {
		super();
		this.id = id;
		this.course_day = course_day;
		this.course_begin_hour = course_begin_hour;
		this.course_end_hour = course_end_hour;
	}

	public SlotDTO() {
		super();
	}
	
	
	

}
