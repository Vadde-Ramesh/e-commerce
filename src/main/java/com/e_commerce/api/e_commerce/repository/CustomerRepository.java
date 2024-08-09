package com.e_commerce.api.e_commerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_commerce.api.e_commerce.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Optional<Customer> findByUserNameAndPassword(String userName, String password);

	Optional<Customer> findByUserNameOrEmailAndPassword(String userName, String email, String password);

}
