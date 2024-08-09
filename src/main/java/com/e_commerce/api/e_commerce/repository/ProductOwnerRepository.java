package com.e_commerce.api.e_commerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e_commerce.api.e_commerce.entity.ProductOwner;
@Repository
public interface ProductOwnerRepository extends JpaRepository<ProductOwner, Integer> {

	Optional<ProductOwner> findByUserNameOrEmailAndPassword(String userName, String email, String password);

}
