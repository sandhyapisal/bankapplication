package com.hcl.banking.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.banking.bankingapp.entity.User;
import com.hcl.banking.bankingapp.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginService loginSeirvice;
	
	@PostMapping("/validateUser/{id}/{passwd}")
	public String addUser(@PathVariable Long id, @PathVariable String passwd){
		String msg = "Welcome ";
		User user = loginSeirvice.getUserByIdAndPasswd(id, passwd);
		if(user==null) {
			msg = "Invalid User";
		}else {
			msg += user.getUserName();
		}
		return msg;
	}
}
