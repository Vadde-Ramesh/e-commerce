package com.e_commerce.api.e_commerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_commerce.api.e_commerce.entity.Address;
import com.e_commerce.api.e_commerce.entity.Customer;
import com.e_commerce.api.e_commerce.repository.AddressRepository;
import com.e_commerce.api.e_commerce.repository.CustomerRepository;

@Service
public class AddressServiceImp implements AddressService {
	@Autowired
	private AddressRepository addRepo;
	@Autowired
	private CustomerRepository custRepo;

	@Override
	public void addAddress(Integer id, Address address) throws Exception {
		Optional<Customer> customer = custRepo.findById(id);
		if(customer.isPresent()) {
			Address address1 = new Address(); 
			address1.setCity(address.getCity());
			address1.setCountry(address.getCountry());
			address1.setCustomerId(id);
			address1.setFirstLine(address.getFirstLine());
			address1.setPincode(address.getPincode());
			address1.setState(address.getState());
			Address addre = addRepo.save(address1);
			customer.get().getAddressId().add(addre.getId());
			custRepo.save(customer.get());
		}else {
			throw new Exception("Bad request");
		}
		
	}

}
