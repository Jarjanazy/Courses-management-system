package com.celil.assessment.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
    
	// a reference to the list of Schedule objects mapping this course object  
    @OneToMany(mappedBy = "schedule_course")
	private List<Schedule> ScheduleList;
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Course() {
		super();
	}

	public Course(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	

	
	
	

}
