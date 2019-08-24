package com.celil.assessment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.celil.assessment.models.Course;
import com.celil.assessment.models.instructor;
import com.celil.assessment.repositories.CourseRepository;
import com.celil.assessment.repositories.instructorRepository;

@Repository
public class InstructorService {
	
	// inject the classRoom repository
	@Autowired
	instructorRepository inst_repo;
	
	// the method takes a class object sent from the controller side
	// it then saves this object to its repository and returns the object.
	public void saveInst(instructor inst) {
		
		inst_repo.save(inst);
		
		System.out.println( inst + " has been saved!");
		
	}
	
	// the method takes the class object id from controller side
	// it then queries the database using the class repository object
	// it returns the class object if found, if not found it returns an empty, new instantiated class object.
	public instructor getInstructor(int inst_id) {
		
		instructor inst = inst_repo.findById(inst_id).orElse(new instructor());
		System.out.println(inst.getName() +" inst is being fetched!");
		
		return inst;
	}
	
	// returns all the classRoom objects in the database.
	public List<instructor> getAllInstructors(){
		List<instructor> instructors = (List<instructor>) inst_repo.findAll();
		
		System.out.println("instructors are being fetched!");
		
		return instructors;
		
		
	}

}
