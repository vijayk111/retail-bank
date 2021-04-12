package com.retailbank.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.retailbank.services.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("jsp/Login/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		LoginService service = new LoginService();
		boolean result= service.userLogin(uname, pwd);
		HttpSession session = request.getSession();
		if(result) {
			session.setAttribute("ud", "getactive");
			CustomerServlet cservlet= new CustomerServlet();
			cservlet.doGet(request, response);
		}else {
			session.setAttribute("message", "Username/Password entered are incorrect!");
			request.getRequestDispatcher("jsp/Login/login.jsp").forward(request, response);
		}
	}

}
