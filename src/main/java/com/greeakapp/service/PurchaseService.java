package com.greeakapp.service;

import java.util.List;

import com.greeakapp.entity.Coupon;
import com.greeakapp.entity.CouponType;
import com.greeakapp.entity.Purchase;

public interface PurchaseService {
	Purchase createPurchase(Purchase purchase);
    Purchase getPurchaseById(Long id);
    void deletePurchaseById(Long id);
    List<Purchase> getAllPurchases();
    List<Purchase> getPurchasesByStudentId(Long studentId);

}
