package com.example.ecommerce.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.dto.MerchantDto;
import com.example.ecommerce.repository.MerchantRepository;

@Repository
public class MerchantDao {
	@Autowired
	MerchantRepository merchantRepository;

	public MerchantDto fetchByMobile(long mobile) {
		return merchantRepository.findByMobile(mobile);
	}

	public MerchantDto fetchByEmail(String email) {
		return merchantRepository.findByEmail(email);
	}

	public MerchantDto save(MerchantDto merchant) {
		return merchantRepository.save(merchant);
		
	}

}
