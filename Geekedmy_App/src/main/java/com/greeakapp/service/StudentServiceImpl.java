package com.greeakapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.greeakapp.entity.Student;
import com.greeakapp.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student addStudent(Student student) {

		return studentRepo.save(student);
	}

	@Override
	public Student getStudentById(Long studentId) {
		return studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student id not found", HttpStatus.NOT_FOUND));

	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();

	}

	@Override
	public void deleteStudentById(Long studentId) {
		Student student = studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student id not found", HttpStatus.NOT_FOUND));

		studentRepo.delete(student);

	}

	@Override
	public Student updateStudent(Long id, Student studentDetials) {

		Student studentDetails = this.getStudentById(id);

		studentDetails.setName(studentDetails.getName());
		studentDetails.setEmail(studentDetails.getEmail());
		studentDetails.setPassword(studentDetails.getPassword());

		return studentRepo.save(studentDetails);
	}

}
