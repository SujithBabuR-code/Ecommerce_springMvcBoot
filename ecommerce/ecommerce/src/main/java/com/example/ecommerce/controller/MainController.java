package com.example.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@GetMapping("/")
	public String loadHome()
	{
		return "Main";
	}
	@GetMapping("/logout")
	public String logOut(HttpSession httpSession,ModelMap modelMap)
	{
		httpSession.invalidate();
		modelMap.put("pos","Logout Sucess");
		return "Main";
	}
}
