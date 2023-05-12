package com.greeakapp.service;

import java.util.List;

import com.greeakapp.entity.Coupon;
import com.greeakapp.entity.Programme;

public interface CouponService {

	Coupon createCoupon(Coupon coupon);

	Coupon updateCoupon(Coupon coupon);

	Coupon getCouponById(Long id);

	void deleteCouponById(Long id);

	List<Coupon> getAllCoupons();

	Coupon applyCouponToProgramme(Long programmeId, String couponCode);

	void removeCouponFromProgramme(Long programmeId);


}
