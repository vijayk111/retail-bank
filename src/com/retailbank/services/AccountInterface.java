package com.retailbank.services;

import java.util.ArrayList;

import com.retailbank.beans.Account;

public interface AccountInterface<T> {
	
	ArrayList<T> getAllAccountsById(String obj);
	
	ArrayList<T> getAllAccounts();
	
	void saveAccount(Account obj);
	
}
