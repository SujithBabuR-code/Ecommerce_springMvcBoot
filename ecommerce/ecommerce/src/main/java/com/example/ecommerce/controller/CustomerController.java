package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ecommerce.dto.CustomerDto;
import com.example.ecommerce.helper.LoginHelper;
import com.example.ecommerce.service.CustomerService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerDto customerDto;
	@Autowired
	CustomerService customerService;
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
	public String signUp(@Valid CustomerDto customerDto, BindingResult result,ModelMap modelMap) {
		if (result.hasErrors())
			return "CustomerSignUp";
		else {
			return customerService.signUp(customerDto, modelMap);
		}
	}
	
	@PostMapping("/verifyotp")
	public String verifyOtp(@RequestParam int enteredOtp,int id,ModelMap map)
	{
		return customerService.verifyOtp(id,enteredOtp,map);
	}
	
	//sign in ()
	
	@PostMapping("/signin")
	public String signIn(LoginHelper helper,ModelMap map,HttpSession session)
	{
		return customerService.signIn(helper,map,session);
	}
	
	@GetMapping("/view-products")
	public String viewProducts(HttpSession httpSession,ModelMap map)
	{
		return customerService.viewProducts(httpSession,map);
	}

}
