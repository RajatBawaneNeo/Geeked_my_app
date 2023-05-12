package com.greeakapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greeakapp.entity.Programme;
import com.greeakapp.exception.ResourceNotFoundException;
import com.greeakapp.repository.ProgrammeRepo;

import lombok.Data;

@Service
@Data
public class ProgrammeServiceImpl implements ProgrammeService {

	@Autowired
	private ProgrammeRepo programmeRepo;

	@Override
	public Programme createProgramme(Programme programme) {
		return programmeRepo.save(programme);
	}

	@Override
	public Programme updateProgramme(Programme programme) {
		Programme existingProgramme = programmeRepo.findById(programme.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Programme not found with id: " + programme.getId()));
		existingProgramme.setTitle(programme.getTitle());
		existingProgramme.setProgrammeCategory(programme.getProgrammeCategory());
		existingProgramme.setPrice(programme.getPrice());
		return programmeRepo.save(existingProgramme);
	}

	@Override
	public Programme getProgrammeById(Long id) {
		return programmeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Programme not found with id: " + id));
	}

	@Override
	public void deleteProgrammeById(Long id) {
		Programme programme = programmeRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Programme not found with id: " + id));
		programmeRepo.delete(programme);
	}

	@Override
	public List<Programme> getAllProgrammes() {
		return programmeRepo.findAll();
	}

	@Override
	public List<Programme> getProgrammesByCategory(String category) {
		return programmeRepo.findByProgrammeCategory(category);
	}

	@Override
	public List<Programme> searchProgrammesByTitle(String keyword) {
		return programmeRepo.findByTitleContaining(keyword);
	}

	@Override
	public List<Programme> getProgrammesByPriceLessThan(double price) {
		return programmeRepo.findByPriceLessThan(price);
	}

	@Override
	public List<Programme> getProgrammesByPriceGreaterThan(double price) {
		return programmeRepo.findByPriceGreaterThan(price);
	}
}
