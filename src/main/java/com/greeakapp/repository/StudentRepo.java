package com.greeakapp.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greeakapp.entity.ProMembership;
import com.greeakapp.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
	Optional<Student> findByEmail(String email);

	List<ProMembership> findProMembershipsByEndDateAfter(LocalDate now);

}
