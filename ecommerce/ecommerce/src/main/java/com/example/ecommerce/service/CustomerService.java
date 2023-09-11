package com.example.ecommerce.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.example.ecommerce.dao.CustomerDao;
import com.example.ecommerce.dto.CustomerDto;
import com.example.ecommerce.helper.MailHelper;
import com.example.ecommerce.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;

	@Autowired
	MailHelper mailHelper;

	@Autowired
	CustomerRepository customerRepository;

	public String signUp(CustomerDto customerDto, ModelMap modelMap) {
		if (customerDao.fetchByEmail(customerDto.getEmail()) == null
				&& customerDao.fetchByPhone(customerDto.getMobile()) == null) {
			int otp = new Random().nextInt(10000, 999999);
			customerDto.setOtp(otp);
			customerDao.save(customerDto);

			// mail sending
			mailHelper.sendOtp(customerDto);
			modelMap.put("id", customerDto.getId());
			return "VerifyOtp1";

		} else {
			modelMap.put("neg", "Email or Phone Already Exists");
			return "CustomerSignUp";
		}
	}

	public String verifyOtp(int id, int enteredOtp, ModelMap map) {
		CustomerDto customerDto = customerDao.fetchById(id);
		if (customerDto == null) {
			map.put("neg", "something went wrong");
			return "Main";
		} else {
			if (customerDto.getOtp() == enteredOtp) {
				customerDto.setStatus(true);
				customerDao.save(customerDto);
				map.put("pos", "Account Verified Succesfully,You can Login now");
				return "Customer";
			}
			else {
				map.put("neg", "OTP missMatch Try Again");
				map.put("id", id);
				return "VerifyOtp1";
			}
		}

	}

}
