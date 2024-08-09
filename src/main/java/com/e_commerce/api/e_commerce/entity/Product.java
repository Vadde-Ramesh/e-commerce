package com.e_commerce.api.e_commerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Integer id;
	
	private String name;
	
	private String description;
	
	private double price;
	
	private Integer Stock;
	
	private Integer productOwnerId;

	public Product() {
		super();
	}

	public Product(String name, String description, double price, Integer stock, Integer productOwnerId) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		Stock = stock;
		this.productOwnerId = productOwnerId;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", Stock="
				+ Stock + ", productOwnerId=" + productOwnerId + "]";
	}

	public Integer getProductOwnerId() {
		return productOwnerId;
	}

	public void setProductOwnerId(Integer productOwnerId) {
		this.productOwnerId = productOwnerId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getStock() {
		return Stock;
	}

	public void setStock(Integer stock) {
		Stock = stock;
	}
	
	

}
