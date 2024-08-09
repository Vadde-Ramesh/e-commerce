package com.e_commerce.api.e_commerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_commerce.api.e_commerce.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByCustomerId(Integer id);

}
