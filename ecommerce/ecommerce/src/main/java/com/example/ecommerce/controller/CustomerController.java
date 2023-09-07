package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecommerce.dto.CustomerDto;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerDto customerDto;

	@GetMapping("")
	public String loadCustomer() {
		return "Customer";
	}

	@GetMapping("/signup")
	public String loadSignUp(ModelMap map) {
		//customerDto.setMobile(1234455566);
		map.put("customerDto", customerDto);
		return "CustomerSignUp";
	}

	@PostMapping("/signup")
	public String signUp(@Valid CustomerDto customerDto, BindingResult result) {
		if (result.hasErrors())
			return "CustomerSignUp";
		else {
			System.out.println(customerDto.toString());
			return "Customer";
			
		}
	}

}
