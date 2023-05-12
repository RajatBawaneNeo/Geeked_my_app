package com.greeakapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greeakapp.entity.Coupon;
import com.greeakapp.entity.CouponType;
import com.greeakapp.entity.ProMembership;
import com.greeakapp.entity.Programme;
import com.greeakapp.entity.ProgrammeCategory;
import com.greeakapp.entity.Purchase;
import com.greeakapp.entity.Student;
import com.greeakapp.exception.ResourceNotFoundException;
import com.greeakapp.repository.CouponRepo;
import com.greeakapp.repository.PurchaseRepo;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseRepo purchaseRepo;

	@Autowired
	private CouponRepo couponRepo;

	private void applyCoupon(Purchase purchase) {
		// Get the purchased programmes and their total value
		List<Programme> programme = new ArrayList<>();
		purchase.getProgramme();
		double totalValue = calculateTotalValue(programme);

		// Check for B4G1 coupon
		if (programme.size() >= 4 && purchase.getCoupon() == null) {
			Programme lowestPricedProgramme = getLowestPricedProgramme(programme);
			Coupon b4g1Coupon = getCouponByType(CouponType.B4G1);
			purchase.setCoupon(b4g1Coupon);
			purchase.getProgramme().remove(lowestPricedProgramme);
		}

		// Check for DEAL_G20 coupon
		if (totalValue >= 10000 && purchase.getCoupon() == null) {
			Coupon dealG20Coupon = getCouponByType(CouponType.DEAL_G20);
			purchase.setCoupon(dealG20Coupon);
		}

		// Check for DEAL_G5 coupon
		if (programme.size() >= 2 && purchase.getCoupon() == null) {
			Coupon dealG5Coupon = getCouponByType(CouponType.DEAL_G5);
			purchase.setCoupon(dealG5Coupon);
		}

	}



	private Coupon getCouponByType(CouponType dealG5) {
		// TODO Auto-generated method stub
		return null;
	}



	private double calculateTotalValue(List<Programme> programmes) {
		double totalValue = 0.0;
		for (Programme programme : programmes) {
			totalValue += programme.getPrice();
		}
		return totalValue;
	}

	private Programme getLowestPricedProgramme(List<Programme> programmes) {
		Programme lowestPricedProgramme = programmes.get(0);
		for (Programme programme : programmes) {
			if (programme.getPrice() < lowestPricedProgramme.getPrice()) {
				lowestPricedProgramme = programme;
			}
		}
		return lowestPricedProgramme;
	}

	@Override
	public Purchase createPurchase(Purchase purchase) {
		// Calculate the discounted price based on coupons and pro membership
		double discountedPrice = calculateDiscountedPrice(purchase);
		purchase.setDiscountedPrice(discountedPrice);

		// Save the purchase
		return purchaseRepo.save(purchase);
	}

	@Override
	public Purchase getPurchaseById(Long id) {
		return purchaseRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Purchase not found with id: " + id));
	}

	@Override
	public void deletePurchaseById(Long id) {
		Purchase purchase = getPurchaseById(id);
		purchaseRepo.delete(purchase);
	}

	@Override
	public List<Purchase> getAllPurchases() {
		return purchaseRepo.findAll();
	}

	@Override
	public List<Purchase> getPurchasesByStudentId(Long studentId) {
		return purchaseRepo.findByStudentId(studentId);
	}

	private double calculateDiscountedPrice(Purchase purchase) {
		double totalPrice = purchase.getPrice();
		double discountedPrice = totalPrice;

		Student student = purchase.getStudent();
		boolean isProMember = student.isProMember();

		// Apply Pro Membership discount
		if (isProMember) {
			discountedPrice -= calculateProMembershipDiscount(totalPrice, student.getProMembership());
		}

		// Apply coupon discount
		Coupon coupon = purchase.getCoupon();
		if (coupon != null) {
			discountedPrice -= calculateCouponDiscount(totalPrice, coupon);
		}

		return discountedPrice;
	}

	private double calculateProMembershipDiscount(double totalPrice, ProMembership proMembership) {
		ProgrammeCategory programmeCategory = proMembership.getProgrammeCategory();

		switch (programmeCategory) {
		case CERTIFICATION:
			return totalPrice * 0.02; // 2% discount
		case DEGREE:
			return totalPrice * 0.03; // 3% discount
		case DIPLOMA:
			return totalPrice * 0.01; // 1% discount
		default:
			return 0.0;
		}
	}

	private double calculateCouponDiscount(double totalPrice, Coupon coupon) {
		double discount = coupon.getDiscount();

		if (discount > totalPrice) {
			return totalPrice; // Apply maximum discount if coupon discount exceeds total price
		} else {
			return discount;
		}
	}




}
