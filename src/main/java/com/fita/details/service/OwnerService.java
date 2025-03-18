package com.fita.details.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fita.details.bean.Flat;
import com.fita.details.bean.Owner;
import com.fita.details.repository.FlatRepository;
import com.fita.details.repository.OwnerRepository;

@Service
public class OwnerService {

	@Autowired
	private OwnerRepository ownerRepo;


	@Autowired
	private FlatRepository flatRepo;

	public Owner saveOrUpdateOwner(Owner owner) {
		if(owner.getOwnerId() != null) {
			Owner existingOwner= ownerRepo.findById(owner.getOwnerId()).get();
			existingOwner.setFirstName(owner.getFirstName());
			existingOwner.setLastName(owner.getLastName());
			existingOwner.setEmailId(owner.getEmailId());
			existingOwner.setPhoneNumber(owner.getPhoneNumber());
			if(owner.getFlat().getFlatId() != null) {
				Flat flat= flatRepo.findById(owner.getFlat().getFlatId()).get();
				existingOwner.setFlat(flat);
			}
			return ownerRepo.save(existingOwner);
		}else {
			if(owner.getFlat().getFlatId() != null) {
				Flat flat= flatRepo.findById(owner.getFlat().getFlatId()).get();
				owner.setFlat(flat);
			}
		}
		return ownerRepo.save(owner);
	}  
	  public Owner getById(Integer ownerId) {
			Optional<Owner> optional=ownerRepo.findById(ownerId);
			Owner flat=optional.get();
			return flat;
		}

		public List<Owner> getAll(){
			List<Owner> All=ownerRepo.findAll();
			return All;
		}
		   public String deleteFlat(Integer ownerId) {
		       ownerRepo.deleteById(ownerId);
		       return "Item Deleted";
	}
	
}