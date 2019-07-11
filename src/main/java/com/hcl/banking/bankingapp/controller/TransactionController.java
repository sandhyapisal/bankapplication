package com.hcl.banking.bankingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.banking.bankingapp.entity.Account;
import com.hcl.banking.bankingapp.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	TransactionService transService;
	
	@GetMapping
	public List<Account> getAllAccounts(){
		return transService.getAllAccounts();
	}
	
	@PostMapping("fundTransfer/{loginUserId}/{accId}/{amount}")
	public String fundTransfer(@PathVariable Long loginUserId, @PathVariable Long accId, Long amount){
		return transService.fundTransfer(loginUserId,accId, amount);
	}
}
