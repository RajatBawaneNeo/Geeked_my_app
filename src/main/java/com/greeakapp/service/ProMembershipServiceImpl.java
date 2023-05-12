package com.greeakapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greeakapp.entity.ProMembership;
import com.greeakapp.entity.Student;
import com.greeakapp.exception.ResourceNotFoundException;
import com.greeakapp.repository.ProMembershipRepo;

@Service
public class ProMembershipServiceImpl implements ProMembershipService {

	@Autowired
	private ProMembershipRepo proMembershipRepo;

	@Override
	public ProMembership createProMembership(ProMembership proMembership) {

		return proMembershipRepo.save(proMembership);
	}

	@Override
	public ProMembership updateProMembership(ProMembership proMembership) {
		return proMembershipRepo.save(proMembership);
		
	}

	@Override
	public Student getProMembershipById(Long id) {
		return proMembershipRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("ProMembership is not available", id));
    }
		

	@Override
	public void deleteProMembershipById(Long id) {
		proMembershipRepo.deleteById(id);

	}

	@Override
	public List<Student> getAllProMemberships() {
		return proMembershipRepo.findAll();
		
	}

}
