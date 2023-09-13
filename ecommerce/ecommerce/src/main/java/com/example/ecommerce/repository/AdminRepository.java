package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.dto.AdminDto;

@Repository
public interface AdminRepository extends JpaRepository<AdminDto, Integer>{

	AdminDto findByEmail(String email);

}
