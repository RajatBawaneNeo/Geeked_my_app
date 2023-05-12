package com.greeakapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greeakapp.entity.CartItem;
import com.greeakapp.exception.CartItemNotFoundException;
import com.greeakapp.exception.ProgrammeNotFoundException;
import com.greeakapp.exception.StudentNotFoundException;
import com.greeakapp.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartItemController {
	@Autowired
	private CartService cartService;

	@PostMapping("/{studentId}/add/{programmeId}")
	public ResponseEntity<String> addToCart(@PathVariable Long studentId, @PathVariable Long programmeId, 
			@RequestBody int quantity) throws StudentNotFoundException, ProgrammeNotFoundException {
		cartService.addToCart(studentId, programmeId, quantity);
		return ResponseEntity.ok("Item added to cart successfully.");
	}

	@DeleteMapping("/{studentId}/remove/{programmeId}")
	public ResponseEntity<String> removeFromCart(@PathVariable Long studentId, @PathVariable Long programmeId)
			throws StudentNotFoundException, ProgrammeNotFoundException, CartItemNotFoundException {
		cartService.removeFromCart(studentId, programmeId);
		return ResponseEntity.ok("Item removed from cart successfully.");
	}

	@GetMapping("/{studentId}")
	public ResponseEntity<List<CartItem>> getCartItems(@PathVariable Long studentId) throws StudentNotFoundException {
		List<CartItem> cartItems = cartService.getCartItems(studentId);
		return ResponseEntity.ok(cartItems);
	}

	@DeleteMapping("/{studentId}/clear")
	public ResponseEntity<String> clearCart(@PathVariable Long studentId) throws StudentNotFoundException {
		cartService.clearCart(studentId);
		return ResponseEntity.ok("Cart cleared successfully.");
	}

	
}
