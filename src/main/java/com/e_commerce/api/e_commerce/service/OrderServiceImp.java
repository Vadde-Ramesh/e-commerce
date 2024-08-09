package com.e_commerce.api.e_commerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_commerce.api.e_commerce.entity.Customer;
import com.e_commerce.api.e_commerce.entity.Order;
import com.e_commerce.api.e_commerce.entity.Product;
import com.e_commerce.api.e_commerce.repository.CustomerRepository;
import com.e_commerce.api.e_commerce.repository.OrderRepository;
import com.e_commerce.api.e_commerce.repository.ProductRepository;

@Service
public class OrderServiceImp implements OrderService {
	@Autowired
	private CustomerRepository custRepo;
	@Autowired
	private OrderRepository ordRepo;
	@Autowired
	private ProductRepository proRepo;

	@Override
	public void addOrder(Integer id, Integer id1) throws Exception {
		Optional<Customer> c1 = custRepo.findById(id);
		Optional<Product> p1 = proRepo.findById(id1);
		if(c1.isPresent() & p1.isPresent()) {
			Order o = new Order();
			o.setCustomerId(c1.get().getId());
			o.setProductId(p1.get().getId());
			o.setPrice(p1.get().getPrice());
			o.setAddressId(c1.get().getAddressId().getFirst());
			ordRepo.save(o);
		}
		else {
			throw new Exception("Bad request");
		}
	}

	@Override
	public List<Order> getAllOrdersByCustomerId(Integer id) throws Exception {
		Optional<Customer> customer = custRepo.findById(id);
		if(customer.isPresent()) {
			return ordRepo.findByCustomerId(id);
		}
		else {
			throw new Exception("Bad request");
		}
	}

}
