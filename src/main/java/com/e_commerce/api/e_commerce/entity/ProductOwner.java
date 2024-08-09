package com.e_commerce.api.e_commerce.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProductOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_owner_id")
	private Integer id;

	private String name;
	
	private String email;
	
	private String password;
	
	private String userName;
	
	private String shopName;
	private List<Integer> productId = new ArrayList<>();;

	public ProductOwner(String name, String email, String password, String userName, String shopName,
			List<Integer> productId) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.shopName = shopName;
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "ProductOwner [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", userName=" + userName + ", shopName=" + shopName + ", productId=" + productId + "]";
	}

	public List<Integer> getProductId() {
		return productId;
	}

	public void setProductId(List<Integer> productId) {
		this.productId = productId;
	}

	public ProductOwner() {
		super();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

}
