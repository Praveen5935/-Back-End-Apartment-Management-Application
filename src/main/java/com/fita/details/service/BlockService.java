package com.fita.details.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fita.details.bean.Block;
import com.fita.details.bean.Floor;
import com.fita.details.repository.BlockRepository;
import com.fita.details.repository.FloorRepository;
@Service
public class BlockService {

	@Autowired
	private BlockRepository blockRepo;
	
	@Autowired
	private FloorRepository floorRepo;

	   public Block saveOrUpdateBlock(Block block) {
	        List<Floor> associatedFloors = new ArrayList<>();
	        if (block.getFloors() != null) {
	            for (Floor floor : block.getFloors()) {
	                if (floor.getFloorId() != null) {
	                    floorRepo.findById(floor.getFloorId()).ifPresent(associatedFloors::add);
	                }
	            }
	        }
	        block.setFloors(associatedFloors);
	        return blockRepo.save(block);
           
}
	  
	    public List<Block> getAllBlocks() {
	        return blockRepo.findAll();
	    }

	   
	    public Block getBlockById(Integer blockId) {
	    	 Optional<Block>opti =blockRepo.findById(blockId);
	 	    Block apt=opti.get();
	 	        return apt;
	 	    }

	    
	    public String deleteblock(Integer blockId) {
		       blockRepo.deleteById(blockId);
		       return "Item Deleted";
	}
	
}