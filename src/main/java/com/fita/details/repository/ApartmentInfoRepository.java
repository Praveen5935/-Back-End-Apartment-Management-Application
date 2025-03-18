package com.fita.details.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fita.details.bean.ApartmentInfo;




@Repository
public interface ApartmentInfoRepository extends JpaRepository<ApartmentInfo, Integer> {

	
	
}






