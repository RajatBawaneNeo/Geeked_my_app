package com.greeakapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greeakapp.entity.Coupon;
import com.greeakapp.entity.CouponType;
import com.greeakapp.entity.Purchase;


@Repository
public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Optional<Coupon> findByCode(String code);

	List<Coupon> findByDiscountGreaterThanEqual(Double discount);

	Optional<Purchase> findByType(CouponType type);

}
