package com.e_commerce.api.e_commerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Integer id;
	
	@JoinColumn(name="customer_id")
	private Integer customerId;
	
	private String firstLine;
	
	private String city;
	
	private String state;
	
	private Integer pincode;
	
	private String country;

	@Override
	public String toString() {
		return "Address [id=" + id + ", customerId=" + customerId +  ", firstLine=" + firstLine + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ ", country=" + country + "]";
	}


	public Address() {
		super();
	}

	public Address(Integer customerId, String firstLine, String city, String state, Integer pincode, String country) {
		super();
		this.customerId = customerId;
		this.firstLine = firstLine;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
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

	public String getFirstLine() {
		return firstLine;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
