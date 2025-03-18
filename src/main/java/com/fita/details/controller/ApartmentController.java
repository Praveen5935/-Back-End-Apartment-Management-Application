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
import com.fita.details.bean.ApartmentInfo;
import com.fita.details.service.ApartmentService;

@RestController
@RequestMapping("/apartment")
public class ApartmentController {
	@Autowired
	private ApartmentService appartmentService;
	
	@PostMapping("/saveorupdate")
	public ApartmentInfo saveAppartmentInfo(@RequestBody ApartmentInfo appartment) {
		ApartmentInfo saveAppartment=appartmentService.saveOrUpdateAppartment(appartment);
		return saveAppartment;
	}
	 @GetMapping
	    public List<ApartmentInfo> getAllApartments() {
	        return appartmentService.getAllApartments();
	    }

	    // Get apartment by ID
	    @GetMapping("/{para}")
	    public ApartmentInfo getApartmentById(@PathVariable("para") Integer appartmentId) {
	        return appartmentService.getApartmentById(appartmentId);
	              
	    }
	    @DeleteMapping("/{para}")
	    public String  deleteApartment(@PathVariable("para") Integer appartmentId) {
	    	
	       return appartmentService.deleteApartment(appartmentId);
	    }

	
	
}

