package com.fita.details.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fita.details.bean.Floor;
import com.fita.details.service.FloorService;
@RestController
@RequestMapping("/floor")
public class FloorController {
	@Autowired
	private FloorService floorService;

	@PostMapping("/saveorupdate")
	public Floor saveOrUpdateFloor(@RequestBody Floor floor) {
		return floorService.saveOrUpdateFloor(floor);
		
	}
	@GetMapping("/{param}")
	public Floor getById(@PathVariable("param") Integer floorId) {
		Floor flat = floorService.getById(floorId);
		return flat;
	}

	@GetMapping
	public List<Floor> getAll(){
		List<Floor> all=floorService.getAll();
		return all;
	}
	 @DeleteMapping("/{para}")
	    public String  deleteFlat(@PathVariable("para") Integer floorId) {
	    	
	       return floorService.deleteFlat(floorId);
	    }


}
