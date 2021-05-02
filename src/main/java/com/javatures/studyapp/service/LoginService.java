package com.javatures.studyapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatures.studyapp.model.LoginBean;
import com.javatures.studyapp.model.User;



@Service
public class LoginService {
	
	@Autowired
	RegisterService registerService;

	public LoginBean findByEmail(LoginBean loginUser) {
		
		
		System.out.println("LoginService.findByEmail loginUser: " + loginUser);
		
		
		LoginBean user = this.registerService.findByEmail(loginUser);
		
		return user;
	}

}
