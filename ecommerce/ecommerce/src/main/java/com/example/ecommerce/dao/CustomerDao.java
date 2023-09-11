package com.example.ecommerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.ecommerce.dto.CustomerDto;
import com.example.ecommerce.repository.CustomerRepository;

@Component
public class CustomerDao {

	@Autowired
	CustomerRepository customerRepository;

	public CustomerDto fetchByPhone(long mobile) {
		return customerRepository.findByMobile(mobile);
	}

	public CustomerDto fetchByEmail(String email) {

		return customerRepository.findByEmail(email);
	}

	public void save(CustomerDto customerDto) {
		customerRepository.save(customerDto);
	}

	public CustomerDto fetchById(int id) {
		 return customerRepository.findById(id).orElse(null);
		
	}

}
