package com.example.ecommerce.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.example.ecommerce.dao.AdminDao;
import com.example.ecommerce.dto.AdminDto;
import com.example.ecommerce.helper.LoginHelper;
import com.example.ecommerce.helper.MailHelper;
import com.example.ecommerce.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;

	@Autowired
	MailHelper mailHelper;

	public String login(LoginHelper helper, ModelMap modelMap) {
		AdminDto adminDto = adminDao.findByEmail(helper.getEmail());
		if (adminDto != null) {
			if (helper.getEmail().equals(adminDto.getEmail())) {
				if (helper.getPassword().equals(adminDto.getPassword())) {
					int otp = new Random().nextInt(10000, 999999);
					adminDto.setOtp(otp);
					adminDao.save(adminDto);

					// calling mail sending method
					mailHelper.sendOtp(adminDto);
					modelMap.put("id", adminDto.getId());
					return "AdminVerify";
				} else {
					modelMap.put("neg", "Password is wrong");
					return "Admin";
				}
			} else {
				modelMap.put("neg", "Email not exist");
				return "Admin";
			}
		} else {
			modelMap.put("neg", "Email not exist");
			return "Admin";
		}
	}

	public String verifyOtp(int id, int enteredOtp,ModelMap map) {
		// TODO Auto-generated method stub
		AdminDto adminDto=adminDao.fetchById(id);
		if(adminDto.getOtp()==enteredOtp)
		{
			return "AdminHome";
		}
		else{
			map.put("id", adminDto.getId());
			map.put("neg", "Otp miss match Re-enter correct Otp");
			return "AdminVerify";
		}
	}

}
