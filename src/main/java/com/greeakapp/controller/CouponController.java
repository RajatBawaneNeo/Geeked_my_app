package com.greeakapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greeakapp.entity.Coupon;
import com.greeakapp.service.CouponService;

@RestController
@RequestMapping("/coupons")
public class CouponController {

	@Autowired
	private CouponService couponService;

	@PostMapping
	public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon) {
		Coupon createdCoupon = couponService.createCoupon(coupon);
		return new ResponseEntity<>(createdCoupon, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Coupon> updateCoupon(@PathVariable Long id, @RequestBody Coupon coupon) {
		coupon.setId(id);
		Coupon updatedCoupon = couponService.updateCoupon(coupon);
		return new ResponseEntity<>(updatedCoupon, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Coupon> getCouponById(@PathVariable Long id) {
		Coupon coupon = couponService.getCouponById(id);
		return new ResponseEntity<>(coupon, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCouponById(@PathVariable Long id) {
		couponService.deleteCouponById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping
	public ResponseEntity<List<Coupon>> getAllCoupons() {
		List<Coupon> coupons = couponService.getAllCoupons();
		return new ResponseEntity<>(coupons, HttpStatus.OK);
	}

	@PostMapping("/apply/{programmeId}")
	public ResponseEntity<Coupon> applyCouponToProgramme(@PathVariable Long programmeId,
			@RequestParam String couponCode) {
		Coupon appliedCoupon = couponService.applyCouponToProgramme(programmeId, couponCode);
		return new ResponseEntity<>(appliedCoupon, HttpStatus.OK);
	}

	@PostMapping("/remove/{programmeId}")
	public ResponseEntity<Void> removeCouponFromProgramme(@PathVariable Long programmeId) {
		couponService.removeCouponFromProgramme(programmeId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
