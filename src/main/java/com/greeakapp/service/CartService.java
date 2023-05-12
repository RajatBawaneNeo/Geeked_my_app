package com.greeakapp.service;

import java.util.List;

import com.greeakapp.entity.CartItem;
import com.greeakapp.entity.Coupon;
import com.greeakapp.exception.ProgrammeNotFoundException;
import com.greeakapp.exception.StudentNotFoundException;

public interface CartService {
	void addToCart(Long studentId, Long programmeId, int quantity) throws StudentNotFoundException, ProgrammeNotFoundException;

	void removeFromCart(Long studentId, Long programmeId) throws StudentNotFoundException, ProgrammeNotFoundException;

	List<CartItem> getCartItems(Long studentId) throws StudentNotFoundException;

	void clearCart(Long studentId) throws StudentNotFoundException;

	
}
