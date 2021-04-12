package com.retailbank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.retailbank.beans.Account;
import com.retailbank.utilities.DBCon;

public class AccountDao implements AccountDaoInterface<Account> {

	private static Connection con= null;
	private static Statement smt = null;
	private static ResultSet rs = null;
	
	@Override
	public ArrayList<Account> getAllAccountsById(String obj) {
		ArrayList<Account> list= new ArrayList<Account>();
		
		String getAllAccountsByIdQuery= "Select * from accounts where customerId='"+obj+"'";
		try {
			con = DBCon.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(getAllAccountsByIdQuery);
			while(rs.next()) {
				Account a= new Account();
				a.setAccountId(rs.getString("accountId"));
				a.setCustomerID(rs.getString("customerId"));
				a.setAccountType(rs.getString("accountType"));
				a.setStatus(rs.getString("status"));
				a.setBalance(rs.getDouble("balance"));
				a.setLastTransaction(rs.getTimestamp("lastTransaction"));
				list.add(a);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBCon.closeConnection();
		}
		
		return list;
	}

	@Override
	public ArrayList<Account> getAllAccounts() {
		ArrayList<Account> list= new ArrayList<Account>();		
		String getAllAccountsQuery= "Select * from accounts";
		try {
			con = DBCon.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(getAllAccountsQuery);
			while(rs.next()) {
				Account a= new Account();
				a.setAccountId(rs.getString("accountId"));
				a.setCustomerID(rs.getString("customerId"));
				a.setAccountType(rs.getString("accountType"));
				a.setStatus(rs.getString("status"));
				a.setBalance(rs.getDouble("balance"));
				a.setLastTransaction(rs.getTimestamp("lastTransaction"));
				list.add(a);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBCon.closeConnection();
		}		
		return list;
	}

	@Override
	public void saveAccount(Account obj) {
		String saveAccount = "Insert into accounts(customerId, accountType, status, balance, lastTransaction) "
				+ "values('"+obj.getCustomerID()+"','"+obj.getAccountType()+"','"+obj.getStatus()+"','"
				+obj.getBalance()+"',timestamp '"+obj.getLastTransaction()+"')";
		System.out.println(saveAccount);
		try {
			con= DBCon.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(saveAccount);
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBCon.closeConnection();
		}
	}

}
