package com.hcl.banking.bankingapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.banking.bankingapp.entity.Account;
import com.hcl.banking.bankingapp.entity.User;
import com.hcl.banking.bankingapp.repository.AccountRepository;
import com.hcl.banking.bankingapp.repository.UserRepository;

@Service
public class RegistrationService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AccountRepository accRepository;
	
	public void registerUser(User user, Account account) {
		userRepository.save(user);
		account.setUid(user.getId());
		accRepository.save(account);
	}
}
