package com.greeakapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greeakapp.entity.CartItem;
import com.greeakapp.entity.Purchase;
import com.greeakapp.entity.Student;
import com.greeakapp.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student savedStudent = studentService.addStudent(student);
		return ResponseEntity.ok(savedStudent);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		Student student = studentService.getStudentById(id);
		return ResponseEntity.ok(student);
	}

	@GetMapping("/")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = studentService.getAllStudents();
		return ResponseEntity.ok(students);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
		Student updatedStudent = studentService.updateStudent(id, studentDetails);
		return ResponseEntity.ok(updatedStudent);
	}
	 @PostMapping("/{studentId}/purchase")
	    public ResponseEntity<Purchase> purchaseProgrammes(@PathVariable Long studentId,
	                                                       @RequestBody CartItem[] cartItems,
	                                                       @RequestParam(required = false) String couponCode,
	                                                       @RequestParam(defaultValue = "false") boolean isProMember) {
	        Purchase purchase = studentService.purchaseProgrammes(studentId, cartItems, couponCode, isProMember);
	        return ResponseEntity.status(HttpStatus.CREATED).body(purchase);
	    }
	}

