package com.fita.details.service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fita.details.bean.Flat;
import com.fita.details.bean.Visitor;
import com.fita.details.repository.FlatRepository;
import com.fita.details.repository.VisitorRepository;


@Service
public class VisitorService {

	@Autowired
	private VisitorRepository visitorRepo;

	@Autowired
	private FlatRepository flatRepo;

	public Visitor saveorupdateVisitor(Visitor visitor) {
		List<Flat> visitingFlats = new ArrayList<>();
		Visitor existingVisitor=new Visitor();
		if(visitor.getVisitorId()!=null) {
			existingVisitor = visitorRepo.findById(visitor.getVisitorId()).get();
			existingVisitor.setFirstName(visitor.getFirstName());
			existingVisitor.setLastName(visitor.getLastName());
			existingVisitor.setVisitingDate(visitor.getVisitingDate());
			if (visitor.getVisitingflatsInfo() != null) {
				for (Flat flat : visitor.getVisitingflatsInfo()) {
					if (flat.getFlatId() != null) {
						flatRepo.findById(flat.getFlatId()).ifPresent(visitingFlats::add);
					}
				}
			}
			existingVisitor.setVisitingflatsInfo(visitingFlats);
			return visitorRepo.save(existingVisitor);
		}else{
			if(visitor.getVisitingflatsInfo() != null) {
				for (Flat flat : visitor.getVisitingflatsInfo()) {
					if (flat.getFlatId() != null) {
						flatRepo.findById(flat.getFlatId()).ifPresent(visitingFlats::add);
					}
				}
			}
			visitor.setVisitingflatsInfo(visitingFlats);
			return visitorRepo.save(visitor);
		}
	}
	 public  Visitor getById(Integer visitorId) {
			Optional< Visitor> optional=visitorRepo.findById(visitorId);
			Visitor flat=optional.get();
			return flat;
		}

		public List< Visitor> getAll(){
			List< Visitor> All=visitorRepo.findAll();
			return All;
		}
		   public String deleteFlat(Integer visitorId) {
		       visitorRepo.deleteById(visitorId);
		       return "Item Deleted";
	}
		   public List<Visitor> getVisitorsForFlat(Integer flatNumber) {  
			   return visitorRepo.findAll().stream() // Implement filtering based on flat number if necessary.
			   .filter(visitor -> ((Flat) visitor.getVisitingflatsInfo()).getFlatNumber().equals(flatNumber))  
			   .collect(Collectors.toList());  
			   }  

			   public List<Visitor> getVisitorsForBlockAndMonth(Long blockId, int month) {  
			   // Logic to fetch visitors based on block ID and month. Implement filtering based on block ID if necessary.
			   LocalDate startDate = LocalDate.of(LocalDate.now().getYear(), month, 1);   
			   LocalDate endDate = startDate.plusMonths(1).minusDays(1);   
			   return visitorRepo.findAll().stream() // Implement filtering based on block ID if necessary.
			   .filter(visitor -> !((Visitor) visitor).getVisitingDate().isBefore(startDate) && !visitor.getVisitingDate().isAfter(endDate))   
			   .collect(Collectors.toList());   
			   }  

			   public List<Visitor> getVisitorsForBlockMonthAndFlat(Long blockId, Integer flatNumber, int month) {   
			   // Logic to fetch visitors based on block ID, month and flat number. Implement filtering based on block ID if necessary.
			   LocalDate startDate = LocalDate.of(LocalDate.now().getYear(), month, 1);   
			   LocalDate endDate = startDate.plusMonths(1).minusDays(1);   
			   return visitorRepo.findAll().stream() // Implement filtering based on block ID if necessary.
			   .filter(visitor -> ((Flat) visitor.getVisitingflatsInfo()).getFlatNumber().equals(flatNumber))   
			   .filter(visitor -> !((Visitor) visitor).getVisitingDate().isBefore(startDate) && !visitor.getVisitingDate().isAfter(endDate))   
			   .collect(Collectors.toList());   
			   }
			


}