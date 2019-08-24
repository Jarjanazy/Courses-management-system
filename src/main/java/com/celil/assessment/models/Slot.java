package com.celil.assessment.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Slot {
	
	public static enum Day {
		sunday,
		monday,
		tuesday,
		wendsday,
		thursday,
		friday,
		saturday;
		}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	// the day that the slot takes place in
	@Enumerated(EnumType.STRING)
    @Column(length = 8)
	private Day course_day;
		
	// the time which the slot starts at (hour)
	@Column
	private int course_begin_hour;
	
	// the time which the slot ends at (hour)
	@Column
	private int course_end_hour;
	
	// a reference to the list of Schedule objects mapping this classRoom object 
	@OneToMany(mappedBy = "schedule_slot")
	private List<Schedule> scheduleList;
	
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Day getCourse_day() {
		return course_day;
	}


	public void setCourse_day(Day course_day) {
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


	public List<Schedule> getScheduleList() {
		return scheduleList;
	}


	public void setScheduleList(List<Schedule> scheduleList) {
		this.scheduleList = scheduleList;
	}

    
    
    
	

}
