package com.hcl.banking.bankingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.banking.bankingapp.entity.Account;
import com.hcl.banking.bankingapp.entity.User;
import com.hcl.banking.bankingapp.service.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationSeirvice;
	
	@PostMapping("/registerUser")
	public void addUser(@RequestBody User user){
		Account account = new Account();
		long accNo = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
		account.setAccId(accNo);
		account.setAccName("Saving");
		account.setBalance(10000L);
		
		registrationSeirvice.registerUser(user, account);
	}
}
