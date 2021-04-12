package com.retailbank.beans;

import java.sql.Timestamp;

public class Customer {
	
	private int customerId;
	private int ssnId;
	private String firstname;
	private String lastname;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private int zipcode;
	private String dob;
	private String status;
	private Timestamp lastUpdated;
	
	public Customer() {}

	public Customer(int customerId, int ssnId, String firstname, String lastname, String addressLine1,
			String addressLine2, String city, String state, int zipcode, String dob, String status,
			Timestamp lastUpdated) {
		super();
		this.customerId = customerId;
		this.ssnId = ssnId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.dob = dob;
		this.status = status;
		this.lastUpdated = lastUpdated;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getSsnId() {
		return ssnId;
	}

	public void setSsnId(int ssnId) {
		this.ssnId = ssnId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String date) {
		this.dob = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	
}
