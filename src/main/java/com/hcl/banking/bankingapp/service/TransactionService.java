package com.hcl.banking.bankingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.banking.bankingapp.entity.Account;
import com.hcl.banking.bankingapp.repository.AccountRepository;

@Service
public class TransactionService {
	
	@Autowired
	AccountRepository accRepository;
	
	public List<Account> getAllAccounts(){
		return accRepository.findAll();
	}
	
	public String fundTransfer(Long loginUserId, Long accId, Long amount) {
		String msg = "";
		Optional<Account> opt = accRepository.findById(accId);
		Account loginUserAcc = accRepository.findByUid(loginUserId);
		if(opt.isPresent()) {
			Account acc = opt.get();
			
			if(loginUserAcc.getBalance() >= amount) {
				loginUserAcc.setBalance(loginUserAcc.getBalance()-amount);
				acc.setBalance(acc.getBalance()+amount);
				accRepository.save(loginUserAcc);
				accRepository.save(acc);
				msg = amount + "rs has been transfered successfully.";
			}else {
				msg = "Transaction amount should be less than your current balance.";
			}
		}else {
			msg = "Selected Account Number is invalid.";
		}
		return msg;
	}
}
