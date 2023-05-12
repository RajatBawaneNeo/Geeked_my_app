package com.greeakapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.greeakapp.entity.Programme;

public interface ProgrammeRepo extends JpaRepository<Programme, Long> {
	List<Programme> findByProgrammeCategory(String programmeCategory);

	List<Programme> findByTitleContaining(String keyword);

	List<Programme> findByPriceLessThan(double price);

	List<Programme> findByPriceGreaterThan(double price);

}
