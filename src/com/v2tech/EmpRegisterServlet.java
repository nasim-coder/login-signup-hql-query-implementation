package com.v2tech;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Userdao;

/**
 * Servlet implementation class EmpRegisterServlet
 */
@WebServlet("/EmpRegisterServlet")
public class EmpRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String salary = request.getParameter("salary");
			String password = request.getParameter("password");
			
			Userdao dao = new Userdao();
			int a = dao.eregister(name, email, salary, password);
			if(a>0)
			{
				out.println("<h1>You are Registered succesfully</h1>");
			}
			else
			{
				out.println("<h1>Something Went Wrong</h1>");
			}
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
	}

}
