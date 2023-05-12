package com.greeakapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greeakapp.entity.Programme;
import com.greeakapp.service.ProgrammeService;

@RestController
@RequestMapping("programme")
public class ProgrammeController {

	@Autowired
	private ProgrammeService programmeService;

	@PostMapping
	public ResponseEntity<Programme> createProgramme(@RequestBody Programme programme) throws Exception {
		Programme createdProgramme = programmeService.createProgramme(programme);
		return new ResponseEntity<>(createdProgramme, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Programme> updateProgramme(@PathVariable Long id, @RequestBody Programme programme)
			throws Exception {
		programme.setId(id);
		Programme updatedProgramme = programmeService.updateProgramme(programme);
		return ResponseEntity.ok(updatedProgramme);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Programme> getProgrammeById(@PathVariable Long id) throws Exception {
		Programme programme = programmeService.getProgrammeById(id);
		return ResponseEntity.ok(programme);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProgrammeById(@PathVariable Long id) throws Exception {
		programmeService.deleteProgrammeById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Programme>> getAllProgrammes() throws Exception {
		List<Programme> programmes = programmeService.getAllProgrammes();
		return ResponseEntity.ok(programmes);
	}

	@GetMapping("/category/{category}")
	public ResponseEntity<List<Programme>> getProgrammesByCategory(@PathVariable String category) throws Exception {
		List<Programme> programmes = programmeService.getProgrammesByCategory(category);
		return ResponseEntity.ok(programmes);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Programme>> searchProgrammesByTitle(@RequestParam String keyword) throws Exception {
		List<Programme> programmes = programmeService.searchProgrammesByTitle(keyword);
		return ResponseEntity.ok(programmes);
	}

	@GetMapping("/price/less-than/{price}")
	public ResponseEntity<List<Programme>> getProgrammesByPriceLessThan(@PathVariable double price) throws Exception {
		List<Programme> programmes = programmeService.getProgrammesByPriceLessThan(price);
		return ResponseEntity.ok(programmes);
	}

	@GetMapping("/price/greater-than/{price}")
	public ResponseEntity<List<Programme>> getProgrammesByPriceGreaterThan(@PathVariable double price)
			throws Exception {
		List<Programme> programmes = programmeService.getProgrammesByPriceGreaterThan(price);
		return ResponseEntity.ok(programmes);
	}

}
