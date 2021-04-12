package com.retailbank.controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.retailbank.beans.Account;
import com.retailbank.beans.Customer;
import com.retailbank.services.AccountService;
import com.retailbank.services.CustomerServices;

/**
 * Servlet implementation class AccountServlet
 */
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String w= request.getParameter("v");
		AccountService service = new AccountService();
		HttpSession session = request.getSession();
		if(w.equals("getall")) {
			ArrayList<Account> list= service.getAllAccounts();
			session.setAttribute("list", list);
			request.getRequestDispatcher("jsp/Customer/allAccounts.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action= request.getParameter("action");
		//String csid = request.getParameter("ssnid");
		Account a= new Account();
		a.setCustomerID(request.getParameter("cid"));
		a.setBalance(Double.parseDouble(request.getParameter("depositAmount")));
		a.setAccountType(request.getParameter("accountType"));
		Date update= new Date();		 
		long time = update.getTime();		 
		Timestamp ts = new Timestamp(time);
		a.setLastTransaction(ts);
		AccountService service = new AccountService();
		//CustomerServices cservice = new CustomerServices();
		//HttpSession session = request.getSession();
		if(action.equals("add")) {
			System.out.println("/saveAcc");
			service.saveAccount(a);
			//Customer c= cservice.findBySSNID(csid);
			//session.setAttribute("c", c);
			request.getRequestDispatcher("jsp/Customer/updateCustomer.jsp").forward(request, response);
		}
	}

}
