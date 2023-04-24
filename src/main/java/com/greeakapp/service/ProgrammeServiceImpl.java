package com.greeakapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greeakapp.repository.ProgrammeRepo;

@Service
public class ProgrammeServiceImpl implements ProgrammeService{
	
	@Autowired
	private ProgrammeRepo programmeRepo;
	

}
