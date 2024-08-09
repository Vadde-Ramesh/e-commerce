package com.e_commerce.api.e_commerce.service;

import java.util.List;

import com.e_commerce.api.e_commerce.entity.Order;

public interface OrderService {

	void addOrder(Integer id, Integer id1) throws Exception;

	List<Order> getAllOrdersByCustomerId(Integer id) throws Exception;

}
