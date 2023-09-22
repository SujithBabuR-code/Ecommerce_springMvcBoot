package com.example.ecommerce.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.dto.MerchantDto;
import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.helper.LoginHelper;
import com.example.ecommerce.service.MerchantService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/merchant")
public class MerchantController {

	@Autowired
	MerchantService merchantService;

	@Autowired
	MerchantDto merchantDto;
	
	@Autowired
	ProductDto productDto;

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
	public String signIn(LoginHelper helper,ModelMap map,HttpSession session)
	{
		return merchantService.signIn(helper,map,session);
	}
	
	@GetMapping("/productpage")
	public String addProductPage(ModelMap modelMap,HttpSession session)
	{
		MerchantDto merchantDto=(MerchantDto) session.getAttribute("merchantDto");
		if(merchantDto!=null)
		{
			modelMap.put("productDto", productDto);
			return "AddProduct";
		}
		else {
			modelMap.put("neg", "Invalid Session please Login Again");
			return "Main";
		}
		
	}
	@GetMapping("/viewItems")
	public String viewProduct()
	{
		return "";
	}
	
//	addproduct page from request
	
	@PostMapping("/add-product")
	public String addProduct(@Valid ProductDto productDto,BindingResult result,@RequestParam MultipartFile  pic,
			ModelMap map, HttpSession session)throws IOException
	{
		MerchantDto merchantDto=(MerchantDto) session.getAttribute("merchantDto");
		if(merchantDto!=null)
		{
			if(result.hasErrors())
			{
				return "AddProduct";
			}
			else {
				return merchantService.addProduct(productDto,pic,map,merchantDto);
			}
		}
		else {
			map.put("neg","Invalid Session");
			return "Main";
		}
	}
}
