package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ecommerce.dto.MerchantDto;
import com.example.ecommerce.service.MerchantService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/merchant")
public class MerchantController {

	@Autowired
	MerchantService merchantService;

	@Autowired
	MerchantDto merchantDto;

	@GetMapping("")
	public String loadMerchant() {
		return "Merchant";
	}

	@GetMapping("/signup")
	public String loadSignUp(ModelMap map) {
//		merchantDto.setMobile(123456789);
		map.put("merchantDto", merchantDto);
		return "MerchantSignup";
	}

	@PostMapping("/signup")
	public String signUp(@Valid MerchantDto merchant, BindingResult result, ModelMap modelMap) {
		if (result.hasErrors()) {
			return "MerchantSignup";
		} else {
			return merchantService.signUp(merchant, modelMap);
		}

	}

	// verify Otp
	@PostMapping("/verifyotp")
	public String verifyOtp(@RequestParam int enteredOtp, int id, ModelMap modelMap) {
		return merchantService.verifyOtp(id, enteredOtp, modelMap);
	}
	
	//sign In method
	@PostMapping("/signin")
	public String signIn(@ModelAttribute MerchantDto merchantDto)
	{
		return "done";
	}
}
