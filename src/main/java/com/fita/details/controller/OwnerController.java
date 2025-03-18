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
import com.fita.details.bean.Owner;
import com.fita.details.service.OwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;

	@PostMapping("/saveorupdate")
	public Owner saveOrUpdateOwner(@RequestBody Owner owner) {
		return ownerService.saveOrUpdateOwner(owner);
		
	}
	@GetMapping("/{param}")
	public Owner getById(@PathVariable("param") Integer ownerId) {
		Owner flat = ownerService.getById(ownerId);
		return flat;
	}

	@GetMapping
	public List<Owner> getAll(){
		List<Owner> all=ownerService.getAll();
		return all;
	}
	 @DeleteMapping("/{para}")
	    public String  deleteFlat(@PathVariable("para") Integer ownerId) {
	    	
	       return ownerService.deleteFlat(ownerId);
	    }


	
}