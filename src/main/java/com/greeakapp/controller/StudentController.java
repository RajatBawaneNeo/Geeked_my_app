package com.greeakapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.greeakapp.entity.Student;
import com.greeakapp.service.ResourceNotFoundException;
import com.greeakapp.service.StudentService;
import com.greeakapp.service.StudentServiceImpl;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();

	}

	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		try {
			Student student = studentService.getStudentById(id);
			return new ResponseEntity<>(student, HttpStatus.OK);
		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}

	}

}
