package com.e_commerce.api.e_commerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_commerce.api.e_commerce.entity.Customer;
import com.e_commerce.api.e_commerce.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {
	@Autowired
	private CustomerRepository custRepo;

	@Override
	public Customer saveCustomer(Customer customer) {
		return custRepo.save(customer);
	}

	@Override
	public Customer updateCustomer(Integer id, Customer customer) throws Exception {
		Optional<Customer> customer1 = custRepo.findById(id);
		if(customer1.isPresent()) {
			Customer customer2 = customer1.get();
			customer2.setId(id);
			customer2.setName(customer.getName());
			customer2.setEmail(customer.getEmail());
			customer2.setPassword(customer.getPassword());
			customer2.setUserName(customer.getUserName());
			return custRepo.save(customer2);
		}
		else {
			throw new Exception("Bad Request");
		}
	}

	@Override
	public Customer findByUserNameOrEmailAndPassword(String userName,String email, String password) throws Exception {
		Optional<Customer> customer1 = custRepo.findByUserNameOrEmailAndPassword(userName,email, password);
		if(customer1.isPresent()) {
			return customer1.get();
		}
		else {
			throw new Exception("Bad Request");
		}
	}

}
