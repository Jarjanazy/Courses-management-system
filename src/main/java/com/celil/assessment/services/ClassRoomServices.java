package com.celil.assessment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.celil.assessment.models.ClassRoom;
import com.celil.assessment.repositories.ClassRoomRepository;
import com.celil.assessment.services.interfaces.IClassRoom;
import java.util.List;

@Service
public class ClassRoomServices implements IClassRoom{
	
	// inject the classRoom repository
	@Autowired
	ClassRoomRepository classRoom_repo;
	
	// the method takes a class object sent from the controller side
	// it then saves this object to its repository and returns the object.
	public void saveClassRoom(ClassRoom classRoomObj) {
		
		classRoom_repo.save(classRoomObj);
		
		System.out.println( classRoomObj + "has been saved!");
		
	}
	
	// the method takes the class object id from controller side
	// it then queries the database using the class repository object
	// it returns the class object if found, if not found it returns an empty, new instantiated class object.
	public ClassRoom getClassRoom(int classRoom_id) {
		
		ClassRoom classRoomObj = classRoom_repo.findById(classRoom_id).orElse(new ClassRoom());
		System.out.println(classRoomObj.getName() +" classRoom is being fetched!");
		
		return classRoomObj;
	}
	
	// returns all the classRoom objects in the database.
	public List<ClassRoom> getAllClassRooms(){
		List<ClassRoom> ClassRooms = (List<ClassRoom>) classRoom_repo.findAll();
		
		System.out.println("classRooms are being fetched!");
		
		return ClassRooms;
		
		
	}
	

}
