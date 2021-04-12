package com.retailbank.services;

import java.util.ArrayList;

import com.retailbank.beans.Customer;
import com.retailbank.dao.CustomerDao;

public class CustomerServices implements CustomerInterface<Customer> {
	
	private static CustomerDao dao;
	
	public CustomerServices() {
		dao = new CustomerDao();
	}
	
	@Override
	public ArrayList<Customer> findActiveCustomers() {
		return dao.findActiveCustomers();
	}

	@Override
	public boolean saveCustomer(Customer obj) {
		return dao.saveCustomer(obj);
	}

	@Override
	public Customer findBySSNID(String obj) {
		return dao.findBySSNID(obj);
	}

	@Override
	public Customer updateCustomer(Customer obj) {
		return dao.updateCustomer(obj);
	}

	@Override
	public void deleteCustomer(String obj) {
		dao.deleteCustomer(obj);		
	}

	@Override
	public ArrayList<Customer> getAllCustomers() {
		return dao.getAllCustomers();
	}

}
