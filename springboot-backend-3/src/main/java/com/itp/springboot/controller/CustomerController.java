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
import com.itp.springboot.model.Customer;
import com.itp.springboot.repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@GetMapping("/customer")
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}		
	
	
	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	
	@GetMapping("/customer/{customer_id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long customer_id) {
		Customer customer = customerRepository.findById(customer_id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + customer_id));
		return ResponseEntity.ok(customer);
	}
	
	
	
	@PutMapping("/customer/{customer_id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long customer_id, @RequestBody Customer customerDetails){
		Customer customer = customerRepository.findById(customer_id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + customer_id));
		
		customer.setName(customerDetails.getName());
		customer.setAddress(customerDetails.getAddress());
		customer.setName(customerDetails.getName());
		customer.setEmail(customerDetails.getEmail());
		customer.setProduct_id(customerDetails.getProduct_id());
		
		Customer updatedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedCustomer);
	}
	

	@DeleteMapping("/customer/{customer_id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long customer_id){
		Customer customer = customerRepository.findById(customer_id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + customer_id));
		
		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}
