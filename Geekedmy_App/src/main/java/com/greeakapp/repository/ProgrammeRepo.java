package com.greeakapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greeakapp.entity.Programme;

@Repository
public interface ProgrammeRepo extends JpaRepository<Programme, Long> {
	List<Programme> findByCategory(String category);

	List<Programme> findByTitleContaining(String keyword);

	List<Programme> findByPriceLessThan(double price);

	List<Programme> findByPriceGreaterThan(double price);

}
