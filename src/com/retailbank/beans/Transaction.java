package com.retailbank.beans;

import java.sql.Date;

public class Transaction {
	
	private String transactionId;
	private Date transactionDate;
	private int formAccountId;
	private int toAccountId;
	private double amount;
	private double balance;
	
	public Transaction(String transactionId, Date transactionDate, int formAccountId, int toAccountId, double amount,
			double balance) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.formAccountId = formAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
		this.balance = balance;
	}
	
	public Transaction() {}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getFormAccountId() {
		return formAccountId;
	}

	public void setFormAccountId(int formAccountId) {
		this.formAccountId = formAccountId;
	}

	public int getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(int toAccountId) {
		this.toAccountId = toAccountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}	
}
