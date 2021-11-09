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

import com.itp.springboot.model.Product;

import com.itp.springboot.repository.ProductRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")


public class ProductController {
	
	@Autowired
	private  ProductRepository  productRepository;
	
	
	@GetMapping("/product")
	public List< Product> getAllProduct(){
		return  productRepository.findAll();
	}		
	
	
	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	
	@GetMapping("/product/{product_id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long product_id) {
		Product product = productRepository.findById(product_id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" + product_id));
		return ResponseEntity.ok(product);
	}
	
	
	
	@PutMapping("/product/{product_id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long product_id, @RequestBody Product productDetails){
		Product product = productRepository.findById(product_id)
				.orElseThrow(() -> new ResourceNotFoundException("Product not exist with id :" +product_id));
		
		
		product.setP_name(productDetails.getP_name());
		product.setWeight(productDetails.getWeight());
		product.setPrice(productDetails.getPrice());
		
		
		
		Product updatedProduct = productRepository.save(product);
		return ResponseEntity.ok(updatedProduct);
	}
	
	
	@DeleteMapping("/product/{product_id}")
	public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long product_id){
		Product product = productRepository.findById(product_id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" +product_id));
		
		productRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
