package com.retailbank.dao;

import java.util.ArrayList;

public interface CustomerDaoInterface<T> {
	ArrayList<T> findActiveCustomers();
	ArrayList<T> getAllCustomers();
	boolean saveCustomer(T obj);
	
	T findBySSNID(String obj);
	
	T updateCustomer(T obj);
	
	void deleteCustomer(String obj);
}
