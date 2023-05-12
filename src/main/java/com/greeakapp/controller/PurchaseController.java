package com.greeakapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greeakapp.entity.Purchase;
import com.greeakapp.service.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;

	@PostMapping("")
	public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase) {
		Purchase newPurchase = purchaseService.createPurchase(purchase);
		return new ResponseEntity<>(newPurchase, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Purchase> getPurchaseById(@PathVariable Long id) {
		Purchase purchase = purchaseService.getPurchaseById(id);
		return new ResponseEntity<>(purchase, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePurchaseById(@PathVariable Long id) {
		purchaseService.deletePurchaseById(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("")
	public ResponseEntity<List<Purchase>> getAllPurchases() {
		List<Purchase> purchases = purchaseService.getAllPurchases();
		return new ResponseEntity<>(purchases, HttpStatus.OK);
	}

	@GetMapping("/students/{studentId}")
	public ResponseEntity<List<Purchase>> getPurchasesByStudentId(@PathVariable Long studentId) {
		List<Purchase> purchases = purchaseService.getPurchasesByStudentId(studentId);
		return new ResponseEntity<>(purchases, HttpStatus.OK);
	}

}
