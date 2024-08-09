package com.e_commerce.api.e_commerce.service;

import com.e_commerce.api.e_commerce.entity.ProductOwner;

public interface ProductOwnerService {

	ProductOwner saveProductOwner(ProductOwner productOwner);

	ProductOwner updateProductOwner(Integer id, ProductOwner productOwner) throws Exception;

	ProductOwner findByUserNameOrEmailAndPassword(String userName, String email, String password) throws Exception;

}
