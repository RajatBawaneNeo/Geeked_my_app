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
import org.springframework.web.bind.annotation.RestController;

import com.greeakapp.entity.ProMembership;
import com.greeakapp.entity.Student;
import com.greeakapp.service.ProMembershipService;

@RestController
@RequestMapping("/api/pro-memberships")
public class ProMembershipController {
	
	    @Autowired
	    private ProMembershipService proMembershipService;

	    @PostMapping
	    public ResponseEntity<ProMembership> createProMembership(@RequestBody ProMembership proMembership) {
	        ProMembership createdProMembership = proMembershipService.createProMembership(proMembership);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdProMembership);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<ProMembership> updateProMembership(@PathVariable("id") Long id, @RequestBody ProMembership proMembership) {
	        proMembership.setId(id);
	        ProMembership updatedProMembership = proMembershipService.updateProMembership(proMembership);
	        return ResponseEntity.ok(updatedProMembership);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Student> getProMembershipById(@PathVariable("id") Long id) {
	        Student proMembership = proMembershipService.getProMembershipById(id);
	        return ResponseEntity.ok(proMembership);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProMembershipById(@PathVariable("id") Long id) {
	        proMembershipService.deleteProMembershipById(id);
	        return ResponseEntity.noContent().build();
	    }

	    @GetMapping
	    public ResponseEntity<List<Student>> getAllProMemberships() {
	        List<Student> proMemberships = proMembershipService.getAllProMemberships();
	        return ResponseEntity.ok(proMemberships);
	    }
	}


