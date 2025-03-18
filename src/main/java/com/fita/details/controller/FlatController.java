package com.fita.details.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fita.details.bean.Flat;
import com.fita.details.service.FlatService;

@RestController
@RequestMapping("/flat")
public class FlatController {
	@Autowired
	private FlatService flatService;
	@PostMapping("/saveorupdate")
	public Flat saveFlatInfo(@RequestBody Flat flat) {
		Flat saveFlat=flatService.saveOrUpdateFlatInfo(flat);
		return saveFlat;
	}

	@GetMapping("/{param}")
	public Flat getById(@PathVariable("param") Integer flatId) {
		Flat flat = flatService.getById(flatId);
		return flat;
	}

	@GetMapping
	public List<Flat> getAll(){
		List<Flat> all=flatService.getAll();
		return all;
	}
	 @DeleteMapping("/{para}")
	    public String  deleteFlat(@PathVariable("para") Integer flatId) {
	    	
	       return flatService.deleteFlat(flatId);
	    }

	

}

