package com.e_commerce.api.e_commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_commerce.api.e_commerce.entity.Product;
import com.e_commerce.api.e_commerce.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService proSer;
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> products = proSer.findAll();
		return ResponseEntity.ok(products);
	}

}
