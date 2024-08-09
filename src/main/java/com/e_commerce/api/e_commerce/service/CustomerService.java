package com.e_commerce.api.e_commerce.service;

import com.e_commerce.api.e_commerce.entity.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);

	Customer updateCustomer(Integer id, Customer customer) throws Exception;

//	Customer findByUserNameAndPassword(String userName, String password) throws Exception;

	Customer findByUserNameOrEmailAndPassword(String userNameOrEmail, String userNameOrEmail2, String password) throws Exception;


}
