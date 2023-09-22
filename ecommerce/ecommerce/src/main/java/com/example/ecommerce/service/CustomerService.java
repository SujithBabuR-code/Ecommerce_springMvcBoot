package com.example.ecommerce.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.example.ecommerce.dao.CustomerDao;
import com.example.ecommerce.dto.CustomerDto;
import com.example.ecommerce.helper.LoginHelper;
import com.example.ecommerce.helper.MailHelper;
import com.example.ecommerce.repository.CustomerRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class CustomerService {
	@Autowired
	CustomerDao customerDao;

	@Autowired
	MailHelper mailHelper;

	@Autowired
	CustomerRepository customerRepository;

	public String signUp(CustomerDto customerDto, ModelMap modelMap) {
		CustomerDto customerDto1 = customerDao.fetchByEmail(customerDto.getEmail());
		CustomerDto customerDto2 = customerDao.fetchByPhone(customerDto.getMobile());
		if (customerDto1 == null && customerDto2 == null) {
			int otp = new Random().nextInt(10000, 999999);
			customerDto.setOtp(otp);
			customerDao.save(customerDto);
			// mail sending
			mailHelper.sendOtp(customerDto);
			modelMap.put("id", customerDto.getId());
			return "VerifyOtp1";

		} else {
			if (customerDto1 != null) {
				if (customerDto1.isStatus()) {
					modelMap.put("neg", "Email already exists");
					return "CustomerSignUp";
				} else {
					if (customerDto2 != null) {
						mailHelper.sendOtp(customerDto1);
						modelMap.put("id", customerDto1.getId());
						return "VerifyOtp1";
					} else {
						modelMap.put("neg", " Same Email with different phone number exists");
						return "CustomerSignp";
					}
				}
			} else {
				modelMap.put("neg", "Phone number already exists");
				return "CustomerSignUp";
			}
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
			} else {
				map.put("neg", "OTP missMatch Try Again");
				map.put("id", id);
				return "VerifyOtp1";
			}
		}

	}

	public String signIn(LoginHelper helper, ModelMap modelMap, HttpSession session) {
		CustomerDto customerDto = customerDao.fetchByEmail(helper.getEmail());
		if (customerDto != null) {
			if (customerDto.isStatus()) {
				if (helper.getPassword().equals(customerDto.getPassword())) {
					session.setMaxInactiveInterval(150);
					session.setAttribute("customerDto", customerDto);
					return "CustomerHome";
				} else {
					modelMap.put("neg", "Password Incorrect");
					return "Customer";
				}
			} else {
				mailHelper.sendOtp(customerDto);
				modelMap.put("id", customerDto.getId());
				return "VerifyOtp1";
			}
		} else {
			modelMap.put("neg", "Email doesn't  exist");
			return "Customer";
		}
	}

	public String viewProducts(HttpSession httpSession,ModelMap map) {
		// TODO Auto-generated method stub
		CustomerDto customerDto = (CustomerDto) httpSession.getAttribute("customerDto");
		if (customerDto != null) {
			return "ViewProducts";
		} else {
			map.put("neg", "session ended please logIn again");
			return "Customer";
		}
	}

}
