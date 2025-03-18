package com.fita.details.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fita.details.bean.Visitor;
@Repository
public interface VisitorRepository extends JpaRepository<Visitor,Integer>{

	Optional<Visitor> findByVisitingflatsInfoFlatNumber(Integer flatNumber);

	

	

	
	

	   
	}

