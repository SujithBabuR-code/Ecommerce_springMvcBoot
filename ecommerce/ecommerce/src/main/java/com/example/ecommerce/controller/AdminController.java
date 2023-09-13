package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ecommerce.dto.AdminDto;
import com.example.ecommerce.helper.LoginHelper;
import com.example.ecommerce.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	AdminService adminService;
	
	@GetMapping("")
	public String loadAdmin() {
		return "Admin";
	}
	@PostMapping("/login")
	public String adminLogin(LoginHelper helper,ModelMap map)
	{
		return adminService.login(helper,map);
	}
	
	@PostMapping("/verifyotp")
	public String adminVerifyOtp(@RequestParam int id,int enteredOtp,ModelMap modelMap)
	{
		//System.out.println(id+" "+enteredOtp);
		 return adminService.verifyOtp(id,enteredOtp,modelMap);
		
	}
	
}
