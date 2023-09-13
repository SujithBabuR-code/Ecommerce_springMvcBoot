package com.example.ecommerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.dto.AdminDto;
import com.example.ecommerce.repository.AdminRepository;

@Repository
public class AdminDao {

	@Autowired
	AdminRepository adminRepository;

	public AdminDto findByEmail(String email) {
		return adminRepository.findByEmail(email);
	}

	public void save(AdminDto adminDto) {
		// TODO Auto-generated method stub
		adminRepository.save(adminDto);
	}

	public AdminDto fetchById(int id) {
		// TODO Auto-generated method stub
		 return adminRepository.findById(id).orElse(null);
	}

}
