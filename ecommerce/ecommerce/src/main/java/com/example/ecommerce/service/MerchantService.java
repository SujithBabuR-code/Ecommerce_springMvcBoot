package com.example.ecommerce.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.dao.MerchantDao;
import com.example.ecommerce.dto.MerchantDto;
import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.helper.LoginHelper;
import com.example.ecommerce.helper.MailHelper;
import com.example.ecommerce.repository.MerchantRepository;

import jakarta.servlet.http.HttpSession;


@Service
public class MerchantService {

	@Autowired
	MerchantDao merchantDao;

	@Autowired
	MerchantRepository merchantRepository;

	@Autowired
	MailHelper mailHelper;

	public String signUp(MerchantDto merchant, ModelMap modelMap) {
		MerchantDto merchantDto1 = merchantDao.fetchByEmail(merchant.getEmail());
		MerchantDto merchantDto2 = merchantDao.fetchByMobile(merchant.getMobile());
		if (merchantDto1 == null && merchantDto2 == null) {
			int otp = new Random().nextInt(10000, 999999);
			merchant.setOtp(otp);
			merchantDao.save(merchant);
			// mail sending
			mailHelper.sendOtp(merchant);
			modelMap.put("id", merchant.getId());
			return "VerifyOtp";
		} else {
			if (merchantDto1 != null) {
				if (merchantDto1.isStatus()) {
					modelMap.put("neg", "Email already exists");
					return "MerchantSignup";
				} else {
					if (merchantDto2 != null) {
						mailHelper.sendOtp(merchantDto1);
						modelMap.put("id", merchantDto1.getId());
						return "VerifyOtp";
					} else {
						modelMap.put("neg", " Same Email with different phone number exists");
						return "MerchantSignUp";
					}
				}
			} else {
				modelMap.put("neg", "Phone number already exists");
				return "MerchantSignup";
			}
		}

	}

	public String verifyOtp(int id, int enteredOtp, ModelMap map) {
		MerchantDto merchantDto = merchantDao.fetctById(id);
		if (merchantDto == null) {
			map.put("neg", "Something went wrong");
			return "Main";
		} else {
			if (merchantDto.getOtp() == enteredOtp) {
				merchantDto.setStatus(true);
				merchantDao.save(merchantDto);
				map.put("pos", "Account Verified SuccessFully ,You can login Now");
				return "Merchant";
			} else {
				map.put("neg", "OTP miss match try Again");
				map.put("id", id);
				return "VerifyOtp";
			}
		}
	}

	public String signIn(LoginHelper helper, ModelMap modelMap, HttpSession session) {
		MerchantDto merchantDto = merchantDao.fetchByEmail(helper.getEmail());
		if(merchantDto!=null)
		{
			if(merchantDto.isStatus())
			{
				if(helper.getPassword().equals(merchantDto.getPassword()))
				{
					session.setMaxInactiveInterval(150);
					session.setAttribute("merchantDto", merchantDto);
					return "MerchantHome";
				}
				else {
					modelMap.put("neg", "Password is incorrect");
					return "Merchant";
				}
			}
				else {
					mailHelper.sendOtp(merchantDto);
					modelMap.put("id", merchantDto.getId());
					return "VerifyOtp";
				}
			}
		else {
			modelMap.put("neg", "email is not existing");
			return "Merchant";
		}

	}

	public String addProduct(ProductDto productDto, MultipartFile pic, ModelMap map, MerchantDto merchantDto) throws IOException {
		
		byte[] picture=new byte[pic.getInputStream().available()];
		pic.getInputStream().read(picture);

		productDto.setPicture(picture);
		List<ProductDto> list=merchantDto.getProductDtos();

		if(list == null)
		{
			list= new ArrayList<ProductDto>();
		}
		list.add(productDto);
		merchantDto.setProductDtos(list);
		merchantDao.save(merchantDto);
		map.put("pos", "Product Added Sucessfully");
		return "MerchantHome";
	}
}
