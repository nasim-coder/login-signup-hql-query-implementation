<!DOCTYPE HTML>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Home</title>
	</head>
	<body>
	<%
beans.Employees user=(beans.Employees)session.getAttribute("user");
	if(user==null)
	{
		response.sendRedirect("login.html");
    }
%>
<h3>-: Hello!!! ${user.name}, We Welcome you here :-</h3>
<a href="show_emp_data.jsp">show my data</a>
	</body>
</html>