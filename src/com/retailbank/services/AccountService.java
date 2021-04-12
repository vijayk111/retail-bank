package com.retailbank.services;

import java.util.ArrayList;

import com.retailbank.beans.Account;
import com.retailbank.dao.AccountDao;

public class AccountService implements AccountInterface<Account> {

	private static AccountDao dao;
	
	public AccountService() {
		dao= new AccountDao();
	}
	
	@Override
	public ArrayList<Account> getAllAccountsById(String obj) {
		return dao.getAllAccountsById(obj);
	}

	@Override
	public ArrayList<Account> getAllAccounts() {
		return dao.getAllAccounts();
	}

	@Override
	public void saveAccount(Account obj) {
		dao.saveAccount(obj);
	}
}
