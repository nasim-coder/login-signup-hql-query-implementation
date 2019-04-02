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
beans.Admins admin=(beans.Admins)session.getAttribute("admin");
	if(admin==null)
	{
		response.sendRedirect("login.html");
    }
%>

<form action="UpdateServlet" method ="post">
Id : <input type ="number" name ="id" required>
Name : <input type="text" name="name">
Email :<input type="text" name="email">
Salary : <input type ="text" name = "salary">
<input type = "submit" value="Update">
</form>
<br><br><br>
Please enter every field to create a record in Employee table
<form action="EmpRegisterServlet" method="post">
Name : <input type ="text" name ="name" required>
Email :<input type="text" name =""email required>
Salary : <input type= "text" name = "salary" required>
Password :<input type ="password" name "password" required>
<input type="submit" value ="Create Record">
</form> 
<br><br><br>
Or You can just delete entire record by providing Id of that record...
<form action="DeleteServlet" method="post">
Id : <input type ="number" name = "id" required>
<input type ="submit" value="Delete">
</form>
</body>
</html>