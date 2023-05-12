/*
 * package com.greeakapp.entity;
 * 
 * import javax.validation.constraints.NotBlank;
 * 
 * import jakarta.persistence.Column; import jakarta.persistence.Entity; import
 * jakarta.persistence.GeneratedValue; import
 * jakarta.persistence.GenerationType; import jakarta.persistence.Id; import
 * jakarta.persistence.JoinColumn; import jakarta.persistence.JoinTable; import
 * jakarta.persistence.ManyToOne; import jakarta.persistence.Table; import
 * lombok.Getter; import lombok.Setter;
 * 
 * @Entity
 * 
 * @Table(name = "carts")
 * 
 * @Getter
 * 
 * @Setter public class Cart {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * 
 * @Column(name = "cart_id") private Long id;
 * 
 * @NotBlank(message = "Name id mandatory")
 * 
 * @ManyToOne
 * 
 * @JoinTable(name = "student_cart", joinColumns = @JoinColumn(name =
 * "cart_name"), inverseJoinColumns = @JoinColumn(name = "student_id"))
 * 
 * private Student student;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "cart_id", referencedColumnName = "programme_id") private
 * Programme programme;
 * 
 * @Column(name = "programme_quantity") private Integer quantity;
 * 
 * }
 */