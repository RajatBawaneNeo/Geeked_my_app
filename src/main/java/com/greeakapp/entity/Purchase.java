package com.greeakapp.entity;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "purchase")
@Getter
@Setter
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_id")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne
	@JoinColumn(name = "programme_id")
	private Programme programme;

	@NotNull
	@Column(name = "price")
	private Double price;

	@Column(name = "discounted_Price")
	private Double discountedPrice;

	@NotNull
	@Column(name = "purchase_Date", updatable = false)
	private LocalDate purchaseDate;
	
	@ManyToOne
	@JoinColumn(name = "coupon_id")
	private Coupon coupon;


	public List<Student> getPurchaseItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
