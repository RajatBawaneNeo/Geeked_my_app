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
@Table(name = "coupons")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="coupon_id")
	private Long id;
	@NotBlank(message = "Name is mandatory")
	@Column(name ="coupon_name")
	private String name;
	@NotBlank(message = " Code is mendatory")
	@Column(name ="coupon_code")
	private String code;
	@NotNull(message = "Discount must be positive number")
	private Double discount;

}
