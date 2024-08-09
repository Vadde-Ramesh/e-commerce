package com.e_commerce.api.e_commerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_commerce.api.e_commerce.entity.Product;
import com.e_commerce.api.e_commerce.entity.ProductOwner;
import com.e_commerce.api.e_commerce.repository.ProductOwnerRepository;
import com.e_commerce.api.e_commerce.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductRepository prodRepo;
	@Autowired
	private ProductOwnerRepository proRepo;

	@Override
	public void addProduct(Integer id, Product product) throws Exception {
		Optional<ProductOwner> pro1 = proRepo.findById(id);
		if(pro1.isPresent()) {
			Product p = new Product();
			p.setName(product.getName());
			p.setDescription(product.getDescription());
			p.setPrice(product.getPrice());
			p.setStock(product.getStock());
			Product p1 =prodRepo.save(p);
			pro1.get().getProductId().add(p1.getId());
			proRepo.save(pro1.get());
		}else {
			throw new Exception("Bad Request");
		}
	}

	@Override
	public List<Product> findAll() {
		return prodRepo.findAll();
	}

}
