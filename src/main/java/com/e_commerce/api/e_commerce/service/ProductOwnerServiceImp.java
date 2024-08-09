package com.e_commerce.api.e_commerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_commerce.api.e_commerce.entity.ProductOwner;
import com.e_commerce.api.e_commerce.repository.ProductOwnerRepository;

@Service
public class ProductOwnerServiceImp implements ProductOwnerService {
	@Autowired
	private ProductOwnerRepository proRepo;

	@Override
	public ProductOwner saveProductOwner(ProductOwner productOwner) {
		return proRepo.save(productOwner);
	}
	@Override
	public ProductOwner updateProductOwner(Integer id, ProductOwner productOwner) throws Exception {
		Optional<ProductOwner> pro1 = proRepo.findById(id);
		if(pro1.isPresent()) {
			ProductOwner pro2 = pro1.get();
			pro2.setId(id);
			pro2.setName(productOwner.getName());
			pro2.setEmail(productOwner.getEmail());
			pro2.setPassword(productOwner.getPassword());
			pro2.setUserName(productOwner.getUserName());
			pro2.setShopName(productOwner.getShopName());
			return proRepo.save(pro2);
		}
		else {
			throw new Exception("Bad Request");
		}
	}
	@Override
	public ProductOwner findByUserNameOrEmailAndPassword(String userName,String email, String password) throws Exception {
		Optional<ProductOwner> pro1 = proRepo.findByUserNameOrEmailAndPassword(userName,email,password);
		if(pro1.isPresent()) {
			return pro1.get();
		}else {
			throw new Exception("Not Found");
		}
	}

}
