package com.greeakapp.entity;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "carts")
@Getter
@Setter
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Name id mandatory")
	/*
	 * @ManyToOne
	 * 
	 * @JoinTable(name = "student_cart", joinColumns
	 * = @JoinColumn(name="cart_name"), inverseJoinColumns
	 * = @JoinColumn(name="student_id"))
	 */
	private Student student;
	/*
	 * @ManyToOne //@JoinColumn(name = "programme_id", referencedColumnName = "id")
	 */	private Programme programme;
	@Column(name = "pogramme_quantity")
	private Integer quantity;

}
