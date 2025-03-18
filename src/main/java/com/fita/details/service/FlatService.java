package com.fita.details.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fita.details.bean.Flat;
import com.fita.details.bean.Visitor;
import com.fita.details.repository.FlatRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FlatService {

	@Autowired
	private FlatRepository flatRepo;

	public Flat saveOrUpdateFlatInfo(Flat flat) {
		if (flat.getFlatId() != null) {
			Optional<Flat> existingFlatOptional = flatRepo.findById(flat.getFlatId());
			if (existingFlatOptional.isPresent()) {
				Flat updateFlat = existingFlatOptional.get();
				updateFlat.setFlatNumber(flat.getFlatNumber());
				updateFlat.setFlatType(flat.getFlatType());
				updateFlat.setNumberOfFamilyMembers(flat.getNumberOfFamilyMembers());
				return flatRepo.save(updateFlat);
			}
		}
		return flatRepo.save(flat);
	}

	public Flat getById(Integer flatId) {
		Optional<Flat> optional=flatRepo.findById(flatId);
		Flat flat=optional.get();
		return flat;
	}

	public List<Flat> getAll(){
		List<Flat> All=flatRepo.findAll();
		return All;
	}
	   public String deleteFlat(Integer flatId) {
	       flatRepo.deleteById(flatId);
	       return "Item Deleted";
}
	   public Visitor getVisitorsByFlatNumber(Integer flatNumber) {
		   Optional<Visitor> visit=flatRepo.findAllByFlatNumber(flatNumber);
		   Visitor visi=visit.get();
	        return visi;
	    }
}

