package com.greeakapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greeakapp.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
	Optional<Student> findByEmail(String email);
	

}
