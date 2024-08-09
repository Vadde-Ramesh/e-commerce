package com.e_commerce.api.e_commerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer customerId;
	
	private Integer productId;
	
	private Integer addressId;
	
	private double price;

	public Order() {
		super();
	}

	public Order(Integer customerId, Integer productId, Integer addressId, double price) {
		super();
		this.customerId = customerId;
		this.productId = productId;
		this.addressId = addressId;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerId=" + customerId + ", productId=" + productId + ", addressId="
				+ addressId + ", price=" + price + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

}
