package com.fita.details.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fita.details.bean.Block;
import com.fita.details.service.BlockService;

@RestController
@RequestMapping("/block")
public class BlockController {
	@Autowired
	private BlockService blockService;
	
	@PostMapping("/saveorupdate")
	public Block saveBlockInfo(@RequestBody Block Block) {
		Block saveFlat=blockService.saveOrUpdateBlock(Block);
		return saveFlat;
	}
    @GetMapping
    public List<Block> getAllBlocks() {
        return (blockService.getAllBlocks());
    }

    @GetMapping("/{para}")
    public Block getBlockById(@PathVariable("para") Integer blockId) {
        return blockService.getBlockById(blockId);
              
    }

    @DeleteMapping("/{para}")
    public String  deleteBlock(@PathVariable("para") Integer blockId) {
    	
	       return blockService.deleteblock(blockId);
	    }
}

