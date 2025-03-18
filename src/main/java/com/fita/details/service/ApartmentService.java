package com.fita.details.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fita.details.bean.ApartmentInfo;
import com.fita.details.bean.Block;
import com.fita.details.repository.ApartmentInfoRepository;
import com.fita.details.repository.BlockRepository;



@Service
public class ApartmentService {

	@Autowired
	private ApartmentInfoRepository appartmentRepo;	
	@Autowired
	private BlockRepository blockRepo;
	

	   public ApartmentInfo saveOrUpdateAppartment(ApartmentInfo appartment) {
	        List<Block> associatedBlocks = new ArrayList<>();
	        if (appartment.getBlocks() != null) {
	            for (Block block : appartment.getBlocks()) {
	                if (block.getBlockId() != null) {
	                    blockRepo.findById(block.getBlockId()).ifPresent(associatedBlocks::add);
	                }
	            }
	        }
	        appartment.setBlocks(associatedBlocks);
	        return appartmentRepo.save(appartment);
	   }
	   public List<ApartmentInfo> getAllApartments() {
	        return appartmentRepo.findAll();
	    }

	    // Get apartment by ID
	    public ApartmentInfo getApartmentById(Integer appartmentId) {
	    Optional<ApartmentInfo>opti =appartmentRepo.findById(appartmentId);
	    ApartmentInfo apt=opti.get();
	        return apt;
	    }
	    public String deleteApartment(Integer appartmentId) {
	       appartmentRepo.deleteById(appartmentId);
	       return "Item Deleted";
}
}