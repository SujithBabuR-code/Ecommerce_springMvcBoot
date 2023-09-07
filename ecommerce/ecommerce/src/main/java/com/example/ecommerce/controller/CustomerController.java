package com.example.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@GetMapping("")
	public String loadCustomer()
	{
		return "Customer";
	}
	@GetMapping("/signup")
	public String loadSignUp()
	{
		return "CustomerSignUp";
	}
}
