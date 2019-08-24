package com.celil.assessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.celil.assessment.models.ClassRoom;
import com.celil.assessment.models.Slot;
import com.celil.assessment.models.DTO.SlotDTO;
import com.celil.assessment.services.SlotServices;

@RestController
@RequestMapping("/slot")
public class SlotController {
	
	// inject the service object
	@Autowired
	SlotServices slot_services;
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public Slot saveSlot(Slot slot) {
		slot_services.saveSlot(slot);
		
		return slot;
	}
	
	// the method takes the class object id from client side
	// it then forwards the id to the service, and return what ever the service returns as a JSON object. 
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public SlotDTO getSlot(
			@PathVariable("id") int slot_id) {
		
		SlotDTO slot = slot_services.getSlot(slot_id);
				
		return slot;
	}
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<SlotDTO> getAllSlots(){
		List<SlotDTO> slots = slot_services.getAllSlots();
		return slots;
		
	}

}
