package com.greeakapp.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;


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

    @NotNull(message = "Category is mandatory")
    @Column(name = "programme_category")
    private ProgrammeCategory programmeCategory;

    @NotNull(message = "Price is mandatory")
    @Column(name = "programme_price")
    private Double price;

    @OneToMany(mappedBy = "programme")
    private List<Purchase> purchases = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;
    
	public Coupon save(Programme programme) {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(Programme lowestPricedProgramme) {
		// TODO Auto-generated method stub
		
	}

}

