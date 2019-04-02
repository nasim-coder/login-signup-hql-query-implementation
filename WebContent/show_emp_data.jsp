<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
beans.Employees user = (beans.Employees)session.getAttribute("user");
	if(user==null)
	{
		response.sendRedirect("login.html");
    }
%>
<h2>These are your details</h2>
<table style="width:100%" border="2px">
  <tr>
    <th>Name</th>
    <th>Email</th> 
    <th>salary</th>
  </tr>
  <tr>
    <td>${user.name}</td>
    <td>${user.email}</td>
    <td>${user.salary}</td>
  </tr>
  </table>
</body>
</html>