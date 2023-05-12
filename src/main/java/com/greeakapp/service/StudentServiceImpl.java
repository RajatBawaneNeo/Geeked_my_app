package com.greeakapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.greeakapp.entity.CartItem;
import com.greeakapp.entity.Coupon;
import com.greeakapp.entity.ProMembership;
import com.greeakapp.entity.Programme;
import com.greeakapp.entity.Purchase;
import com.greeakapp.entity.PurchaseItem;
import com.greeakapp.entity.Student;
import com.greeakapp.exception.ResourceNotFoundException;
import com.greeakapp.repository.CouponRepo;
import com.greeakapp.repository.PurchaseRepo;
import com.greeakapp.repository.StudentRepo;

import java.time.LocalDate;
import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private CouponRepo couponRepo;
	
	@Autowired
	private PurchaseRepo purchaseRepo;

	@Override
	public Student addStudent(Student student) {

		return studentRepo.save(student);
	}

	@Override
	public Student getStudentById(Long studentId) {
		return studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student id not found", HttpStatus.NOT_FOUND));

	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();

	}

	@Override
	public void deleteStudentById(Long studentId) {
		Student student = studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student id not found", HttpStatus.NOT_FOUND));

		studentRepo.delete(student);

	}

	@Override
	public Student updateStudent(Long id, Student studentDetials) {

		Student studentDetails = this.getStudentById(id);

		studentDetails.setName(studentDetails.getName());
		studentDetails.setEmail(studentDetails.getEmail());
		studentDetails.setPassword(studentDetails.getPassword());

		return studentRepo.save(studentDetails);
	}

	@Override
	public Purchase purchaseProgrammes(Long studentId, CartItem[] cartItems, String couponCode, boolean isProMember) {
		Student student = studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + studentId));

		List<CartItem> cartItemList = Arrays.asList(cartItems);

		double totalProgrammeCost = calculateTotalProgrammeCost(cartItemList);
		double discountedCost = applyDiscounts(totalProgrammeCost, couponCode, isProMember);

		double finalCost = applyEnrollmentFee(discountedCost);

		Purchase purchase = createPurchase(student, cartItemList, finalCost);
		return purchaseRepo.save(purchase);
	}

	private double calculateTotalProgrammeCost(List<CartItem> cartItems) {
		return cartItems.stream().mapToDouble(item -> item.getProgramme().getPrice() * item.getQuantity()).sum();
	}

	private double applyDiscounts(double totalProgrammeCost, String couponCode, boolean isProMember) {
		double discountedCost = totalProgrammeCost;

		if (isProMember) {
			discountedCost = applyProMembershipDiscount(discountedCost);
		}

		Optional<Coupon> coupon = couponRepo.findByCode(couponCode);
		if (coupon.isPresent()) {
			double couponDiscount = coupon.get().getDiscount();
			if (couponDiscount > 0) {
				discountedCost = applyCouponDiscount(discountedCost, couponDiscount);
			}
		}

		return discountedCost;
	}

	private double applyProMembershipDiscount(double totalProgrammeCost) {
		double proMembershipDiscount = 0.0;

		List<ProMembership> proMemberships = studentRepo.findProMembershipsByEndDateAfter(LocalDate.now());
		if (!proMemberships.isEmpty()) {
			ProMembership proMembership = proMemberships.get(0);
			proMembershipDiscount = proMembership.getPrice();
		}

		return totalProgrammeCost - proMembershipDiscount;
	}

	private double applyCouponDiscount(double totalProgrammeCost, double couponDiscount) {
		return totalProgrammeCost - (totalProgrammeCost * (couponDiscount / 100));
	}

	private double applyEnrollmentFee(double totalProgrammeCost) {
		if (totalProgrammeCost < 6666) {
			totalProgrammeCost += 500;
		}
		return totalProgrammeCost;
	}

	private Purchase createPurchase(Student student, List<CartItem> cartItems, double finalCost) {
		Purchase purchase = new Purchase();
		purchase.setStudent(student);
		purchase.setPrice(finalCost);
		purchase.setPurchaseDate(LocalDate.now());

		for (CartItem cartItem : cartItems) {
			Programme programme = cartItem.getProgramme();
			double programmeCost = programme.getPrice() * cartItem.getQuantity();

			PurchaseItem purchaseItem = new PurchaseItem();
			
			purchaseItem.setProgramme(programme);
			purchaseItem.setQuantity(cartItem.getQuantity());
			purchaseItem.setPrice(programmeCost);
			//purchase.getPurchaseItems().add(purchaseItem);
		}

		return purchase;
	}

}
