package com.greeakapp.service;

import java.util.List;

import com.greeakapp.entity.ProMembership;
import com.greeakapp.entity.Student;

public interface ProMembershipService  {
	
	    ProMembership createProMembership(ProMembership proMembership);
	    ProMembership updateProMembership(ProMembership proMembership);
	    Student getProMembershipById(Long id);
	    void deleteProMembershipById(Long id);
	    List<Student> getAllProMemberships();

}
