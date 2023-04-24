package com.greeakapp.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@Table(name = "programme")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Programme {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "programme_id")
	private Long id;
	@NotBlank(message = "Title is mandatory")
	@Column(name = "programme_title")
	private String title;
	
	@NotBlank(message = "Category is mandatory")
	@Column(name = "programme_category")
	private String category;
	@NotNull(message = "price is mendatory")
	@Column(name = "programme_price")
	private Double price;

}
