package com.greeakapp.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pro_membership")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProMembership {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proMembership_id")
	private Long id;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "end_date")
	private LocalDate endDate;

	@Column(name = "price")
	private double price;

	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;

	public ProgrammeCategory getProgrammeCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
