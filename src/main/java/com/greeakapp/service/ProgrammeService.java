package com.greeakapp.service;

import java.util.List;

import com.greeakapp.entity.Programme;

public interface ProgrammeService  {
	
	    Programme createProgramme(Programme programme);

	    Programme updateProgramme(Programme programme);

	    Programme getProgrammeById(Long id);

	    void deleteProgrammeById(Long id);

	    List<Programme> getAllProgrammes();

		List<Programme> getProgrammesByCategory(String category);

		List<Programme> searchProgrammesByTitle(String keyword);

		List<Programme> getProgrammesByPriceLessThan(double price);

		List<Programme> getProgrammesByPriceGreaterThan(double price);

	   
	}

	
	


