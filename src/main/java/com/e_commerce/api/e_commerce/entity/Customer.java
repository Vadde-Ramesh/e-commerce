package com.e_commerce.api.e_commerce.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customerId")
	private Integer id;
	
	private String userName;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private List<Integer> addressId = new ArrayList<>();
	

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", userName=" + userName + ", name=" + name + ", email=" + email + ", password="
				+ password + ", addressId=" + addressId + "]";
	}

	public Customer(String userName, String name, String email, String password, List<Integer> addressId) {
		super();
		this.userName = userName;
		this.name = name;
		this.email = email;
		this.password = password;
		this.addressId = addressId;
	}

	public List<Integer> getAddressId() {
		return addressId;
	}

	public void setAddressId(List<Integer> addressId) {
		this.addressId = addressId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	
	
}
