package com.v2tech;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Userdao;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String name=null;
		int id =Integer.parseInt(request.getParameter("id"));
		name = request.getParameter("name");
		String email = request.getParameter("email");
		String salary = request.getParameter("salary");
		Userdao dao = new Userdao();
		
		if(id>0)
		{
			if(name!=null&name!="")
			{
				dao.updateName(id, name);
			}
			if(email!=null&email!="")
			{
				
				dao.updateEmail(id, email);
			}
			if(salary!=null&salary!="")
			{
				dao.updateSalary(id, salary);
			}
			
		}
		System.out.println(id+"....."+name+"....."+email+"....."+salary);
		System.out.println(name.length());
		}
		catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	

	}
}
	

