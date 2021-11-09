package com.itp.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customer_id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "product_id")
	private String product_id;

	
	
	public Customer() {
		
	}



	public Customer(long customer_id, String name, String address, String phone, String email, String product_id) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.product_id = product_id;
	}



	public long getCustomer_id() {
		return customer_id;
	}



	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getProduct_id() {
		return product_id;
	}



	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	
	
}
