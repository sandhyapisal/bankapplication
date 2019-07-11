package com.hcl.banking.bankingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.banking.bankingapp.entity.User;
import com.hcl.banking.bankingapp.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	UserRepository userRepository;
	
	public User getUserByIdAndPasswd(Long id, String passwd){
		User user = null;
		List<User> userList = userRepository.findByIdAndPassword(id,passwd);
		if(!userList.isEmpty()) {
			user = userRepository.findByIdAndPassword(id,passwd).get(0);
		}
		return user;
	}
}
