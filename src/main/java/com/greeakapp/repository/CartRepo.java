package com.greeakapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/*import com.greeakapp.entity.Cart;*/
import com.greeakapp.entity.CartItem;

public interface CartRepo extends JpaRepository<CartItem, Long> {
	List<CartItem>findByStudentId(Long studenId);
	Optional<CartItem>findByProgrammeIdAndStudentId(Long programmeId, Long studentId);

}
