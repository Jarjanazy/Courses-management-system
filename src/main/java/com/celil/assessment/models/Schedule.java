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
public class Schedule {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	// model the many-to-one relationship between Schedule and Course
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="course_id",referencedColumnName="id")
	private Course schedule_course;
    
    // model the many-to-one relationship between Schedule and ClassRoom
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="classRoom_id",referencedColumnName="id")
	private ClassRoom schedule_classRoom;
    
    // model the many-to-one relationship between Schedule and instructor
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_id",referencedColumnName="id")
	private instructor schedule_instructor;
    
    // model the many-to-one relationship between Schedule and slot
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="slot_id",referencedColumnName="id")
	private Slot schedule_slot;
    
    
    
    

	public Schedule() {
		super();
	}

	// the id is not passed, nor set here because it will be set by the database.
	public Schedule(Course schedule_course, ClassRoom schedule_classRoom, instructor schedule_instructor,
			Slot schedule_slot) {
		super();
		//this.id = id;
		this.schedule_course = schedule_course;
		this.schedule_classRoom = schedule_classRoom;
		this.schedule_instructor = schedule_instructor;
		this.schedule_slot = schedule_slot;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Course getSchedule_course() {
		return schedule_course;
	}

	public void setSchedule_course(Course schedule_course) {
		this.schedule_course = schedule_course;
	}

	public ClassRoom getSchedule_classRoom() {
		return schedule_classRoom;
	}

	public void setSchedule_classRoom(ClassRoom schedule_classRoom) {
		this.schedule_classRoom = schedule_classRoom;
	}

	public instructor getSchedule_instructor() {
		return schedule_instructor;
	}

	public void setSchedule_instructor(instructor schedule_instructor) {
		this.schedule_instructor = schedule_instructor;
	}

	public Slot getSchedule_slot() {
		return schedule_slot;
	}

	public void setSchedule_slot(Slot schedule_slot) {
		this.schedule_slot = schedule_slot;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", schedule_course=" + schedule_course.getName() + ", schedule_classRoom="
				+ schedule_classRoom.getName() + ", schedule_instructor=" + schedule_instructor.getName() + ", schedule_slot="
				+ schedule_slot.getId() + "]";
	}
    
	
    
    
    
    
	

}
