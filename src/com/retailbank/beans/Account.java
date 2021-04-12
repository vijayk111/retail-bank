package com.retailbank.beans;

import java.sql.Timestamp;

public class Account {	
	
	private String accountId;
	private String customerID;
	private String accountType;
	private String status;
	private double balance;
	private Timestamp lastTransaction;
	public Account(String accountId, String customerID, String accountType, String status, double balance,
			Timestamp lastTransaction) {
		super();
		this.accountId = accountId;
		this.customerID = customerID;
		this.accountType = accountType;
		this.status = status;
		this.balance = balance;
		this.lastTransaction = lastTransaction;
	}
	
	public Account() {}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Timestamp getLastTransaction() {
		return lastTransaction;
	}

	public void setLastTransaction(Timestamp lastTransaction) {
		this.lastTransaction = lastTransaction;
	}
		
}
