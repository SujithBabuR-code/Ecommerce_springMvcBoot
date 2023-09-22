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

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;

	@Autowired
	MailHelper mailHelper;

	public String login(LoginHelper helper, ModelMap modelMap, HttpSession session) {
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

	public String verifyOtp(int id, int enteredOtp,ModelMap map,HttpSession session) {
		// TODO Auto-generated method stub
		AdminDto adminDto=adminDao.fetchById(id);
		if(adminDto.getOtp()==enteredOtp)
		{
			session.setAttribute("adminDto", adminDto);
			return "AdminHome";
		}
		else{
			map.put("id", adminDto.getId());
			map.put("neg", "Otp miss match Re-enter correct Otp");
			return "AdminVerify";
		}
	}

	public String logOut(HttpSession httpSession) {
		// TODO Auto-generated method stub
		//AdminDto adminDto=(AdminDto) httpSession.getAttribute("adminDto");
		httpSession.removeAttribute("adminDto");
		return "Admin";
	}

	public String approveItems(HttpSession session,ModelMap map) {
		// TODO Auto-generated method stub
		AdminDto adminDto=(AdminDto) session.getAttribute("adminDto");
		if(adminDto!=null)
		{
		return "ApproveItems";	
		}
		else {
			map.put("neg", "session expired please login again");
			return "Admin";
		}
	}

}
