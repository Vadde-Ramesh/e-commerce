package com.e_commerce.api.e_commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce.api.e_commerce.entity.Address;
import com.e_commerce.api.e_commerce.entity.Customer;
import com.e_commerce.api.e_commerce.entity.Order;
import com.e_commerce.api.e_commerce.service.AddressService;
import com.e_commerce.api.e_commerce.service.CustomerService;
import com.e_commerce.api.e_commerce.service.OrderService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService custSer;
	@Autowired
	private OrderService ordSer;
	@Autowired
	private AddressService addSer;
	
	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		Customer customer1 = custSer.saveCustomer(customer);
		return ResponseEntity.ok(customer1);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Customer> updateCustomerById(@PathVariable("id") Integer id, @RequestBody Customer customer){
		try {
			Customer customer1 = custSer.updateCustomer(id, customer);
			return ResponseEntity.ok(customer1);
		}catch(Exception e){
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/{userNameOrEmail}/{password}")
	public ResponseEntity<Customer> findByUserNameAndPassword(@PathVariable("userNameOrEmail") String userNameOrEmail, @PathVariable("password") String password){
		try {
			Customer customer1 = custSer.findByUserNameOrEmailAndPassword(userNameOrEmail, userNameOrEmail, password);
			return ResponseEntity.ok(customer1);
		}catch(Exception e){
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping("/{customerId}/{productId}")
	public ResponseEntity<String> addOrder(@PathVariable("customerId") Integer customerId, @PathVariable("productId") Integer productId){
		try {
			ordSer.addOrder(customerId, productId);
			return ResponseEntity.ok("Order Successfully Placed");
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@PostMapping("/{id}/address")
	public ResponseEntity<String> addAddress(@PathVariable("id") Integer id, @RequestBody Address address){
		try {
			addSer.addAddress(id, address);
			return ResponseEntity.ok("Address successfully Added");
		}
		catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@GetMapping("/orders/{id}")
	public ResponseEntity<List<Order>> getAllOrdersByCustomer(@PathVariable("id") Integer id){
		try {
			List<Order> orders = ordSer.getAllOrdersByCustomerId(id);
			return ResponseEntity.ok(orders);
		}
		catch(Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
}





