package com.greeakapp.entity;

import javax.validation.constraints.NotBlank;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Student {

	public Student(Long id2, String name2) {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Long id;
	@NotBlank(message = "Name is mandatory")
	@Column(name = "student_name")
	private String name;
	@NotBlank(message = "email is mandatory")
	@Column(name = "student_email")
	private String email;
	@Column(name = "student_password", unique = true)
	@NotBlank(message = "password is mandatory")
	private String password;
	private boolean isProMember;

}
