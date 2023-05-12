package com.greeakapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greeakapp.entity.CartItem;

public interface CartItemRepo extends JpaRepository<CartItem, Long>{

	CartItem findByStudentIdAndProgrammeId(Long studentId, Long programmeId);

	List<CartItem> findAllById(Long studentId);

	void deleteAllByStudentId(Long studentId);

}
