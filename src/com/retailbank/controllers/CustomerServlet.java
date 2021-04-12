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
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServices service= new CustomerServices();
		String sud = request.getParameter("ud");
		String sid= request.getParameter("id");
		HttpSession session = request.getSession();
		if(sid != null) {			
			Customer c= service.findBySSNID(sid);
			session.setAttribute("c", c);
			AccountService aservice= new AccountService();
			ArrayList<Account> list= aservice.getAllAccountsById(Integer.toString(c.getCustomerId())); 
			session.setAttribute("list", list);
			if(sud.equals("u")) {				
				request.getRequestDispatcher("jsp/Customer/updateCustomer.jsp").forward(request, response);
			}else if(sud.equals("d")) {
				request.getRequestDispatcher("jsp/Customer/deleteCustomer.jsp").forward(request, response);
			}else if(sud.equals("g")) {
				request.getRequestDispatcher("jsp/Customer/getInactiveCustomer.jsp").forward(request, response);
			}
		}else {	
				if(sud == null) {
					ArrayList<Customer> list= service.findActiveCustomers();					
					session.setAttribute("list", list);
					request.getRequestDispatcher("jsp/Customer/activeCustomers.jsp").forward(request, response);
				}
				else if(sud.equals("getall")){
					ArrayList<Customer> list1= service.getAllCustomers();
					session.setAttribute("list", list1);
					request.getRequestDispatcher("jsp/Customer/allCustomers.jsp").forward(request, response);
				}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opt= request.getParameter("action");
		CustomerServices service = new CustomerServices();
		System.out.println(opt);
		if(!opt.equals("del")) {
			Customer c = new Customer();
			c.setFirstname(request.getParameter("firstname"));
			c.setLastname(request.getParameter("lastname"));
			c.setSsnId(Integer.parseInt(request.getParameter("ssn")));
			c.setDob(request.getParameter("dob"));
			c.setAddressLine1(request.getParameter("address1"));
			c.setAddressLine2(request.getParameter("address2"));
			c.setCity(request.getParameter("city"));
			c.setState(request.getParameter("state"));
			c.setStatus("active");
			c.setZipcode(Integer.parseInt(request.getParameter("zipcode")));
			Date update= new Date();		 
			long time = update.getTime();		 
			Timestamp ts = new Timestamp(time);
			c.setLastUpdated(ts);					
			if(opt.equals("add")) {						
				if(!service.saveCustomer(c)) {
					request.getRequestDispatcher("jsp/Customer/createCustomer.jsp").forward(request, response);
				}else {
					doGet(request, response);
				}
			}else if(opt.equals("update")) {
				c.setCustomerId(Integer.parseInt(request.getParameter("id")));
				Customer updatedC= service.updateCustomer(c);
				HttpSession session = request.getSession();
				session.setAttribute("c", updatedC);
				request.getRequestDispatcher("jsp/Customer/updateCustomer.jsp").forward(request, response);
			}
		}else if(opt.equals("del")){
			System.out.println("/del");
			service.deleteCustomer(request.getParameter("cid"));
			doGet(request, response);
		}
	}

}
