package com.greeakapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greeakapp.entity.Purchase;

@Repository
public interface PurchaseRepo extends JpaRepository<Purchase, Long> {

}
