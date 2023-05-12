package com.greeakapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greeakapp.entity.Coupon;
import com.greeakapp.entity.Programme;
import com.greeakapp.exception.ResourceNotFoundException;
import com.greeakapp.repository.CouponRepo;
import com.greeakapp.repository.ProgrammeRepo;


@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponRepo couponRepo;

	@Autowired
	private ProgrammeRepo programmeRepo;

	@Override
	public Coupon createCoupon(Coupon coupon) {
		return couponRepo.save(coupon);
	}

	@Override
	public Coupon updateCoupon(Coupon coupon) {
		Optional<Coupon> existingCouponOptional = couponRepo.findById(coupon.getId());
		if (existingCouponOptional.isEmpty()) {
			throw new ResourceNotFoundException("Coupon not found with id: " + coupon.getId());
		}
		return couponRepo.save(coupon);
	}

	@Override
	public Coupon getCouponById(Long id) {
		return couponRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Coupon not found with id: " + id));
	}

	@Override
	public void deleteCouponById(Long id) {
		if (!couponRepo.existsById(id)) {
			throw new ResourceNotFoundException("Coupon not found with id: " + id);
		}
		couponRepo.deleteById(id);
	}

	@Override
	public List<Coupon> getAllCoupons() {
		return couponRepo.findAll();
	}

	@Override
	public Coupon applyCouponToProgramme(Long programmeId, String couponCode) {
		Programme programme = programmeRepo.findById(programmeId)
				.orElseThrow(() -> new ResourceNotFoundException("Programme not found with id: " + programmeId));

		Optional<Coupon> couponOptional = couponRepo.findByCode(couponCode);
		Coupon coupon = couponOptional
				.orElseThrow(() -> new ResourceNotFoundException("Coupon not found with code: " + couponCode));

		programme.setCoupon(coupon);
		return programme.save(programme);

	}

	@Override
	public void removeCouponFromProgramme(Long programmeId) {
		Programme programme = programmeRepo.findById(programmeId)
				.orElseThrow(() -> new ResourceNotFoundException("Programme not found with id: " + programmeId));

		programme.setCoupon(null);
		programmeRepo.save(programme);
	}

}
