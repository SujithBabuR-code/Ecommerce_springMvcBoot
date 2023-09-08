package com.example.ecommerce.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dao.MerchantDao;
import com.example.ecommerce.dto.MerchantDto;
import com.example.ecommerce.repository.MerchantRepository;

import jakarta.validation.Valid;

@Service
public class MerchantService {

	@Autowired
	MerchantDao merchantDao;

	@Autowired
	MerchantRepository merchantRepository;

	public String signUp(MerchantDto merchant) {
		if (merchantDao.fetchByEmail(merchant.getEmail()) == null && merchantDao.fetchByMobile(merchant.getMobile())==null)
		{
			int otp=new Random().nextInt(10000, 999999);
			merchant.setOtp(otp);
			merchantDao.save(merchant);
			return "VerifyOtp";
		}
		else {
			return "MerchantSignup";
		}
	}

}
