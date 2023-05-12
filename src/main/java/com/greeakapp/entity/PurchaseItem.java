package com.greeakapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "purchase_item")
public class PurchaseItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_item_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "programme_id") //, referencedColumnName = "id")
	private Programme programme;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "purchase_id") //, referencedColumnName = "id")
	private Purchase purchase;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private double price;

}
