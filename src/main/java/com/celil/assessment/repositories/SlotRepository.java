package com.celil.assessment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.celil.assessment.models.Slot;

public interface SlotRepository extends CrudRepository<Slot, Integer>{
	
	

}
