package com.greeakapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greeakapp.entity.ProMembership;
import com.greeakapp.entity.Student;

@Repository
public interface ProMembershipRepo extends JpaRepository<Student, Long> {

	ProMembership save(ProMembership proMembership);

}
