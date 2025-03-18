package com.fita.details.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fita.details.bean.Flat;
import com.fita.details.bean.Visitor;

public interface FlatRepository extends JpaRepository<Flat,Integer>{

	Optional<Visitor> findAllByFlatNumber(Integer flatNumber);

}
