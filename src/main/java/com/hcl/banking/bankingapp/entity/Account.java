package com.hcl.banking.bankingapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {
	
	@Id
	@Column(name="acc_id")
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long accId;
	
	@Column(name="acc_name")
	private String accName;
	
	@Column(name="balance")
	private Long balance;
	
	@JoinColumn(name = "uid", referencedColumnName = "uid")
	@Column(name="uid")
	private Long uid;

	public Long getAccId() {
		return accId;
	}

	public void setAccId(Long accId) {
		this.accId = accId;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	
	
}
