package com.itp.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "profile")
public class Profile {
	
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
	
	

	
	
	public Profile() {
		
	}





	public Profile(long customer_id, String name, String address, String phone, String email) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
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





	
	
	
}
