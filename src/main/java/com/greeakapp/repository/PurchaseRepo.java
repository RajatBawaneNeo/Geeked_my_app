package com.greeakapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greeakapp.entity.Purchase;

public interface PurchaseRepo extends JpaRepository<Purchase, Long> {
	 List<Purchase> findByStudentId(Long studentId);

}
