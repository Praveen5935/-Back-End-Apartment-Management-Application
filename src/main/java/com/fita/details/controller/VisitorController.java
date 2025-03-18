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
import com.fita.details.bean.Visitor;
import com.fita.details.service.VisitorService;
@RestController
@RequestMapping("/visitor")
public class VisitorController {

	@Autowired
	private VisitorService visitorService;
	
	@PostMapping("/saveorupdate")
	public Visitor saveorupdateVisitor(@RequestBody Visitor visitor) {
		return visitorService.saveorupdateVisitor(visitor);
	}
	@GetMapping("/{param}")
	public Visitor getById(@PathVariable("param") Integer visitorId) {
		Visitor flat = visitorService.getById(visitorId);
		return flat;
	}

	@GetMapping
	public List<Visitor> getAll(){
		List<Visitor> all=visitorService.getAll();
		return all;
	}
	 @DeleteMapping("/{para}")
	    public String  deleteFlat(@PathVariable("para") Integer visitorId) {
	    	
	       return visitorService.deleteFlat(visitorId);
	    }
	 @GetMapping("/flats/{flatnumber}")  
	 public List<Visitor> listVisitorsForFlat(@PathVariable("flatnumber") Integer flatNumber) {  
	 return visitorService.getVisitorsForFlat(flatNumber);  
	 }  

	 @GetMapping("/blocks/{blockid}/visitors/month/{months}")  
	 public List<Visitor> listVisitorsForBlockAndMonth(@PathVariable("blockid") Long blockId,   
	                                                   @PathVariable("months") int month) {  
	 return visitorService.getVisitorsForBlockAndMonth(blockId, month);  
	 }  

	 @GetMapping("/blocks/{blockid}/flats/{flatnumber}/visitors/month/{months}")  
	 public List<Visitor> listVisitorsForBlockMonthAndFlat(@PathVariable("blockid") Long blockId,   
	                                                        @PathVariable ("flatnumber")Integer flatNumber,   
	                                                        @PathVariable("months") int month) {  
	 return visitorService.getVisitorsForBlockMonthAndFlat(blockId, flatNumber, month);  
	 }  

	    
}
