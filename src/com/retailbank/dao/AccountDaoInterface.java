package com.retailbank.dao;

import java.util.ArrayList;

import com.retailbank.beans.Account;

public interface AccountDaoInterface<T> {
	
	ArrayList<T> getAllAccountsById(String obj);
	
	ArrayList<T> getAllAccounts();
	
	void saveAccount(Account obj);
	
}
