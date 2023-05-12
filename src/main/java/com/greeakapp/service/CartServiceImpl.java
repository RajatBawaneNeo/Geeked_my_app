package com.greeakapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greeakapp.entity.CartItem;
import com.greeakapp.entity.Coupon;
import com.greeakapp.entity.Programme;
import com.greeakapp.entity.Student;
import com.greeakapp.exception.CartItemNotFoundException;
import com.greeakapp.exception.ProgrammeNotFoundException;
import com.greeakapp.exception.StudentNotFoundException;
import com.greeakapp.repository.CartItemRepo;
import com.greeakapp.repository.ProgrammeRepo;
import com.greeakapp.repository.StudentRepo;


@Service

public class CartServiceImpl implements CartService {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private ProgrammeRepo programmeRepo;

	@Autowired
	private CartItemRepo cartItemRepo;

	@Override
	public void addToCart(Long studentId, Long programmeId, int quantity)
			throws StudentNotFoundException, ProgrammeNotFoundException {
		Student student = studentRepo.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + studentId));

		Programme programme = programmeRepo.findById(programmeId)
				.orElseThrow(() -> new ProgrammeNotFoundException("Programme not found with ID: " + programmeId));

		CartItem cartItem = cartItemRepo.findByStudentIdAndProgrammeId(studentId, programmeId);

		if (cartItem != null) {
			cartItem.setQuantity(cartItem.getQuantity() + quantity);
		} else {
			cartItem = new CartItem();
			cartItem.setStudent(student);
			cartItem.setProgramme(programme);
			cartItem.setQuantity(quantity);
		}

		cartItemRepo.save(cartItem);
	}

	@Override
	public void removeFromCart(Long studentId, Long programmeId)
			throws StudentNotFoundException, ProgrammeNotFoundException,CartItemNotFoundException {
		Student student = studentRepo.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + studentId));

		Programme programme = programmeRepo.findById(programmeId)
				.orElseThrow(() -> new ProgrammeNotFoundException("Programme not found with ID: " + programmeId));

		CartItem cartItem = cartItemRepo.findByStudentIdAndProgrammeId(studentId, programmeId);

		if (cartItem == null) {
			throw new CartItemNotFoundException("Cart item not found for student ID: " );
		}

		cartItemRepo.delete(cartItem);
	}

	@Override
	public List<CartItem> getCartItems(Long studentId) throws StudentNotFoundException {
		Student student = studentRepo.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + studentId));

		return cartItemRepo.findAllById(studentId);
	}

	@Override
	public void clearCart(Long studentId) throws StudentNotFoundException {
		Student student = studentRepo.findById(studentId)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + studentId));

		cartItemRepo.deleteAllByStudentId(studentId);
	}

}