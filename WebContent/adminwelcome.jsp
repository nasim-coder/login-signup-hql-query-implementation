<!DOCTYPE HTML>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>welcome Admin</title>
	</head>
	<body>
	<%
beans.Admins admin=(beans.Admins)session.getAttribute("admin");
	if(admin==null)
	{
		response.sendRedirect("login.html");
    }
%>

<a href="show_emp_table.jsp">Show Employee table</a><br>
<a href="update.jsp" >Update or delete employee data</a>
	</body>
</html>