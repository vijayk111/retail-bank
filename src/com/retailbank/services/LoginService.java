package com.retailbank.services;

import com.retailbank.dao.LoginDao;

public class LoginService implements LoginServiceInterface{
	
	private static LoginDao dao;
	
	public LoginService() {
		dao = new LoginDao();
	}
	
	@Override
	public boolean userLogin(String a, String b) {
			return dao.userLogin(a, b);	
	}

}
