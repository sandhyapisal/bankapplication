package com.hcl.banking.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.banking.bankingapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	public Account findByUid(Long accId);
}
