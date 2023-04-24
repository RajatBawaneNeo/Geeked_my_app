package com.greeakapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greeakapp.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
	List<Cart>findByStudentId(Long studenId);
	Optional<Cart>findByProgrammeIdAndStudentId(Long programmeId, Long studentId);

}
