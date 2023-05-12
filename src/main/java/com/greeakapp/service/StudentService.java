package com.greeakapp.service;

import java.util.List;

import com.greeakapp.entity.CartItem;
import com.greeakapp.entity.Purchase;
import com.greeakapp.entity.Student;

public interface StudentService {

	Student addStudent(Student student);

	Student getStudentById(Long studentId);

	List<Student> getAllStudents();

	void deleteStudentById(Long studentId);

	Student updateStudent(Long id, Student student);

	Purchase purchaseProgrammes(Long studentId, CartItem[] cartItems, String couponCode, boolean isProMember);

}
