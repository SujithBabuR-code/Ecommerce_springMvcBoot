package com.example.ecommerce.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.example.ecommerce.dao.MerchantDao;
import com.example.ecommerce.dto.MerchantDto;
import com.example.ecommerce.helper.MailHelper;
import com.example.ecommerce.repository.MerchantRepository;

@Service
public class MerchantService {

	@Autowired
	MerchantDao merchantDao;

	@Autowired
	MerchantRepository merchantRepository;
	
	@Autowired 
	MailHelper mailHelper;

	public String signUp(MerchantDto merchant,ModelMap modelMap) {
		if (merchantDao.fetchByEmail(merchant.getEmail()) == null && merchantDao.fetchByMobile(merchant.getMobile())==null)
		{
			int otp=new Random().nextInt(10000, 999999);
			merchant.setOtp(otp);
			merchantDao.save(merchant);
			
			//mail sending
			mailHelper.sendOtp(merchant);
			modelMap.put("id", merchant.getId());
			return "VerifyOtp";
		}
		else {
			modelMap.put("neg", "Email or Phone Already Exists");
			return "MerchantSignup";
		}
	}

	public String verifyOtp(int id, int enteredOtp,ModelMap map) {
		MerchantDto merchantDto=merchantDao.fetctById(id);
		if(merchantDto==null)
		{
			map.put("neg", "Something went wrong");
			return "Main";
		}
		else {
			if(merchantDto.getOtp()==enteredOtp)
			{
				merchantDto.setStatus(true);
				merchantDao.save(merchantDto);
				map.put("pos", "Account Verifiyed SuccessFully ,You can login Now");
				return "Merchant";
			}
			else
			{
				map.put("neg", "OTP missmatch try Again");
				map.put("id", id);
				return "VerifyOtp";
			}
		}
	}

}
