package com.e_commerce.api.e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce.api.e_commerce.entity.Product;
import com.e_commerce.api.e_commerce.entity.ProductOwner;
import com.e_commerce.api.e_commerce.service.ProductOwnerService;
import com.e_commerce.api.e_commerce.service.ProductService;

@RestController
@RequestMapping("/owner")
public class ProductOwnerController {
	@Autowired
	private ProductOwnerService proSer;
	@Autowired
	private ProductService prodSer;
	
	@PostMapping
	public ResponseEntity<ProductOwner> saveCustomer(@RequestBody ProductOwner productOwner){
		ProductOwner customer1 = proSer.saveProductOwner(productOwner);
		return ResponseEntity.ok(customer1);
	}
	@PutMapping("/{id}")
	public ResponseEntity<ProductOwner> updateCustomerById(@PathVariable("id") Integer id, @RequestBody ProductOwner productOwner){
		try {
			ProductOwner customer1 = proSer.updateProductOwner(id, productOwner);
			return ResponseEntity.ok(customer1);
		}catch(Exception e){
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/{userNameOrEmail}/{password}")
	public ResponseEntity<ProductOwner> findByUserNameAndPassword(@PathVariable("userNameOrEmail") String userNameOrEmail, @PathVariable("password") String password){
		try {
			ProductOwner productOwner = proSer.findByUserNameOrEmailAndPassword(userNameOrEmail, userNameOrEmail, password);
			return ResponseEntity.ok(productOwner);
		}catch(Exception e){
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping("/{id}/product")
	public ResponseEntity<String> addProduct(@PathVariable("id") Integer id, @RequestBody Product product){
		try {
			prodSer.addProduct(id, product);
			return ResponseEntity.ok("Product Added Successfully");
		}
		catch(Exception e){
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}








