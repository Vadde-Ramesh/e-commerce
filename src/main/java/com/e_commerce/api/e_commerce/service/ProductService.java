package com.e_commerce.api.e_commerce.service;

import java.util.List;

import com.e_commerce.api.e_commerce.entity.Product;

public interface ProductService {

	void addProduct(Integer id, Product product) throws Exception;

    List<Product> findAll();

}
