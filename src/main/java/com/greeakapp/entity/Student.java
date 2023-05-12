package com.greeakapp.entity;

import javax.validation.constraints.NotBlank;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Student {

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

	@Column(name = "is_pro_member")
	private boolean isProMember;

	@OneToOne(mappedBy = "student")
	private ProMembership proMembership;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "end_date")
	private LocalDate endDate;

	@OneToMany(mappedBy = "student")
	private List<Purchase> purchases = new ArrayList<>();
}
