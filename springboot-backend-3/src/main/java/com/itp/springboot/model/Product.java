package com.itp.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")

public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long product_id;
	
	@Column(name = "p_name")
	private String p_name;

	@Column(name = "weight")
	private String weight;
	
	@Column(name = "price")
	private String price;
	
	
	
	public Product() {
	}



	public Product(long product_id, String p_name, String weight, String price) {
		super();
		this.product_id = product_id;
		this.p_name = p_name;
		this.weight = weight;
		this.price = price;
	}



	public long getProduct_id() {
		return product_id;
	}



	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}



	public String getP_name() {
		return p_name;
	}



	public void setP_name(String p_name) {
		this.p_name = p_name;
	}



	public String getWeight() {
		return weight;
	}



	public void setWeight(String weight) {
		this.weight = weight;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}
	
	


	
	
	

}
