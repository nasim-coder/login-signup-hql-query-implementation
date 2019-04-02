package com.v2tech;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Employees;
import dao.Userdao;

/**
 * Servlet implementation class EmpLogin
 */
@WebServlet("/EmpLogin")
public class EmpLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Userdao dao = new Userdao();
		Employees user = dao.eauthenticate(email, password);
		
		if(user!=null)
		{
			session.setAttribute("user", user);
			response.sendRedirect("empwelcome.jsp");
		}
		else {
			response.sendRedirect("/login.html");
		}
		
	}

}
