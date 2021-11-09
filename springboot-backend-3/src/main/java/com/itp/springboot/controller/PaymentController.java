package com.itp.springboot.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itp.springboot.exception.ResourceNotFoundException;
import com.itp.springboot.model.Payment;
import com.itp.springboot.repository.PaymentRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PaymentController {

	@Autowired
	private PaymentRepository paymentRepository;
	
	
	@GetMapping("/payment")
	public List<Payment> getAllEmployees(){
		return paymentRepository.findAll();
	}		
	

	@PostMapping("/payment")
	public Payment createPayment(@RequestBody Payment payment) {
		return paymentRepository.save(payment);
	}
	
	
	@GetMapping("/payment/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
		Payment payment = paymentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Payment not exist with id :" + id));
		return ResponseEntity.ok(payment);
	}
	
	
	
	@PutMapping("/payment/{id}")
	public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment paymentDetails){
		Payment payment = paymentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Payment not exist with id :" + id));
		
		payment.setName(paymentDetails.getName());
		payment.setEmail(paymentDetails.getEmail());
		payment.setCard_number(paymentDetails.getCard_number());
		payment.setExpiry_date(paymentDetails.getExpiry_date());
		payment.setCvv(paymentDetails.getCvv());
		
		Payment updatedPayment = paymentRepository.save(payment);
		return ResponseEntity.ok(updatedPayment);
	}
	

	@DeleteMapping("/payment/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePayment(@PathVariable Long id){
		Payment payment = paymentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Payment not exist with id :" + id));
		
		paymentRepository.delete(payment);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}