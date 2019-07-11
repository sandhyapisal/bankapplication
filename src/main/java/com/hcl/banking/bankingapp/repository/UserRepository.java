package com.hcl.banking.bankingapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.banking.bankingapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findByIdAndPassword(Long uid, String passwd);
}
