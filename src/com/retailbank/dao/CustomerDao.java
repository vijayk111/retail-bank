package com.retailbank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.retailbank.beans.Customer;
import com.retailbank.utilities.DBCon;

public class CustomerDao implements CustomerDaoInterface<Customer>{
	
	private static Connection con= null;
	private static Statement smt = null;
	private static ResultSet rs = null;	
	
	
	@Override
	public ArrayList<Customer> findActiveCustomers() {
		ArrayList<Customer> list= new ArrayList<Customer>();
		String findACQuery = "Select * from customers where status like 'active'";
		try {
			con= DBCon.getConnection();
			smt= con.createStatement();
			rs= smt.executeQuery(findACQuery);
			while(rs.next()) {
				Customer c= new Customer();
				c.setCustomerId(rs.getInt("customerId"));
				c.setLastname(rs.getString("lastname"));
				c.setFirstname(rs.getString("firstname"));
				c.setSsnId(rs.getInt("ssnId"));
				c.setLastUpdated(rs.getTimestamp("lastUpdated"));
				c.setDob(rs.getDate("dob").toString());
				c.setLastUpdated(rs.getTimestamp("lastUpdated"));
				list.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBCon.closeConnection();
		}
		return list;
	}


	public boolean saveCustomer(Customer obj) {
		String saveQuery = "insert into customers(ssnId, firstname, lastname, dob, addressLine1, addressLine2, city, state, zipcode, status, lastUpdated)"
				+ " values ('"+obj.getSsnId()+"', '"+obj.getFirstname()+"','"+obj.getLastname()+"',TO_DATE('"+obj.getDob()+"','yyyy-mm-dd'),'"+obj.getAddressLine1()+"','"
				+obj.getAddressLine2()+"','"+obj.getCity()+"','"+obj.getState()+"','"+obj.getZipcode()+"','"+obj.getStatus()+"',timestamp '"
				+obj.getLastUpdated()+"')";
		try {
			con=DBCon.getConnection();
			smt= con.createStatement();
			rs= smt.executeQuery(saveQuery);
			if(rs.next()) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBCon.closeConnection();
		}
		return false;
	}


	@Override
	public Customer findBySSNID(String obj) {
		Customer c= new Customer();
		
		String getCustomerQuery= "select * from customers where ssnId='"+obj+"'";
		try {
			con=DBCon.getConnection();
			smt= con.createStatement();
			rs= smt.executeQuery(getCustomerQuery);
			while(rs.next()) {
				c.setCustomerId(Integer.parseInt(rs.getString("customerId")));
				c.setSsnId(Integer.parseInt(rs.getString("ssnId")));
				c.setFirstname(rs.getString("firstname"));
				c.setLastname(rs.getString("lastname"));
				c.setDob(rs.getDate("dob").toString());
				c.setAddressLine1(rs.getString("addressLine1"));
				c.setAddressLine2(rs.getString("addressLine2"));
				c.setCity(rs.getString("city"));
				c.setState(rs.getString("state"));
				c.setZipcode(rs.getInt("zipcode"));				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBCon.closeConnection();
		}
		return c;
	}


	@Override
	public Customer updateCustomer(Customer obj) {
		String updateQuery = "update customers set ssnId='"+Integer.toString(obj.getSsnId())+"', firstname='"+obj.getFirstname()+"', lastname='"+obj.getLastname()+""
				+ "', dob= TO_DATE('"+obj.getDob()+"','yyyy-mm-dd'), addressLine1='"+obj.getAddressLine1()+"', addressLine2='"+obj.getAddressLine2()+"', city='"+obj.getCity()+""
				+ "', state='"+obj.getState()+"', zipcode='"+obj.getZipcode()+"', lastUpdated=timestamp '"+obj.getLastUpdated()+"'"
				+ " where customerId='"+Integer.toString(obj.getCustomerId())+"'";		
		try {
			con=DBCon.getConnection();
			smt= con.createStatement();
			smt.executeUpdate(updateQuery);
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBCon.closeConnection();
		}
		return obj;
	}


	@Override
	public void deleteCustomer(String obj) {
		String delQuery = "update customers set status='Inactive' where customerId='"+obj+"'";
		try {
			con=DBCon.getConnection();
			smt= con.createStatement();
			smt.executeUpdate(delQuery);
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBCon.closeConnection();
		}		
	}


	@Override
	public ArrayList<Customer> getAllCustomers() {
		ArrayList<Customer> list= new ArrayList<Customer>();
		String getAllQuery = "Select * from customers";
		try {
			con= DBCon.getConnection();
			smt= con.createStatement();
			rs= smt.executeQuery(getAllQuery);
			while(rs.next()) {
				Customer c= new Customer();
				c.setCustomerId(rs.getInt("customerId"));
				c.setLastname(rs.getString("lastname"));
				c.setFirstname(rs.getString("firstname"));
				c.setSsnId(rs.getInt("ssnId"));
				c.setLastUpdated(rs.getTimestamp("lastUpdated"));
				c.setDob(rs.getDate("dob").toString());
				c.setLastUpdated(rs.getTimestamp("lastUpdated"));
				c.setStatus(rs.getString("status"));
				list.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBCon.closeConnection();
		}
		return list;
	}

}
