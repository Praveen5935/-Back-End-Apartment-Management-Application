package com.fita.details.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fita.details.bean.Flat;
import com.fita.details.bean.Floor;
import com.fita.details.repository.FlatRepository;
import com.fita.details.repository.FloorRepository;

@Service
public class FloorService {

	@Autowired
	private FloorRepository floorRepo;
	
	@Autowired
	private FlatRepository flatRepo;
	
	
	   public Floor saveOrUpdateFloor(Floor floor) {
	        // Handle the flats based on their IDs
	        List<Flat> associatedFlats = new ArrayList<>();
	        if (floor.getFlats() != null) {
	            for (Flat flat : floor.getFlats()) {
	                if (flat.getFlatId() != null) {
	                    flatRepo.findById(flat.getFlatId()).ifPresent(associatedFlats::add);
	                }
	            }
	        }

	        floor.setFlats(associatedFlats); // Set the flats list with the resolved Flat objects

	        // Save or update the Floor entity
	        return floorRepo.save(floor);
            
}
	   public Floor getById(Integer floorId) {
			Optional<Floor> optional=floorRepo.findById(floorId);
			Floor flat=optional.get();
			return flat;
		}

		public List<Floor> getAll(){
			List<Floor> All=floorRepo.findAll();
			return All;
		}
		   public String deleteFlat(Integer floorId) {
		       floorRepo.deleteById(floorId);
		       return "Item Deleted";
	}
	   
}