package com.celil.assessment.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.celil.assessment.models.ClassRoom;
import com.celil.assessment.models.Schedule;
import com.celil.assessment.models.Slot;
import com.celil.assessment.models.DTO.ScheduleDTO;
import com.celil.assessment.models.DTO.SlotDTO;
import com.celil.assessment.repositories.SlotRepository;
import com.celil.assessment.services.interfaces.ISlot;

@Service
public class SlotServices implements ISlot{

	@Autowired
	SlotRepository slot_repo;

	public void saveSlot(Slot slot) {		
		
		slot_repo.save(slot);
		
		System.out.println( slot + "has been saved!");
		
	}
	
	public SlotDTO getSlot(int slot_id) {
		
		Slot slot = slot_repo.findById(slot_id).orElse(null);
		
		// if the slot exists in the database
		if (slot != null){
			SlotDTO slotDTO = new SlotDTO(slot.getId(), 
											slot.getCourse_day(), 
											slot.getCourse_begin_hour(), 
											slot.getCourse_end_hour());
			return slotDTO;
		
		}
		
		else {
			return new SlotDTO();
		}
		
	}
	
	// returns all the classRoom objects in the database.
	public List<SlotDTO> getAllSlots(){
		List<Slot> slots = (List<Slot>) slot_repo.findAll();
		
		List<SlotDTO> slotDTO = new ArrayList<SlotDTO>();
		// convert to DTOs
		
		for (Slot slot : slots) {
			slotDTO.add(
					new SlotDTO(slot.getId(), 
							slot.getCourse_day(), 
							slot.getCourse_begin_hour(), 
							slot.getCourse_end_hour())
					);
		}
		
		System.out.println("slots are being fetched!");
		
		return slotDTO;
		
		
	}


	
	

}
