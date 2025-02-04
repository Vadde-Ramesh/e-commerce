package com.e_commerce.api.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_commerce.api.e_commerce.entity.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
