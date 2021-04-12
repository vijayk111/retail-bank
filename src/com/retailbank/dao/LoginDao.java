package com.retailbank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.retailbank.utilities.DBCon;

public class LoginDao implements LoginDaoInterface{
	
	private static Connection con= null;
	private static Statement smt=null;
	private static ResultSet rs = null;
	
	@Override
	public boolean userLogin(String username, String password) {
		
		boolean result= false;
		String loginQuery = "select count(username) from users where username= '"+username+"' and password= '"+password+"'";
		try {
			con = DBCon.getConnection();
			smt= con.createStatement();
			rs= smt.executeQuery(loginQuery);
			int count = 0;
			while(rs.next()) {
				count= rs.getInt("count(username)");
			}
			if(count == 1) {
				return true;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally {
			DBCon.closeConnection();
		}		
		return result;
	}
	
}
