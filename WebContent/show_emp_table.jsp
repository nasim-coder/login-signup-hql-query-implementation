<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.hibernate.SessionFactory,org.hibernate.cfg.Configuration,org.hibernate.query.Query" %>
<%@ page import = "beans.Employees, org.hibernate.Transaction, org.hibernate.Session, java.util.Iterator" %>
<%@ page import = "java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee table</title>
</head>
<body>
<h2>These are Employees details</h2>
<table style="width:100%" border="1px">
<tr>
	<th>Id</th>
    <th>Name</th>
    <th>Email</th> 
    <th>Salary</th>
  </tr>
<%
Employees user=null;
Configuration cfg=new Configuration();
cfg.configure("resources/hibernate.cfg.xml");
SessionFactory sf=cfg.buildSessionFactory();
Session sesn=sf.openSession();
Transaction tx=sesn.beginTransaction();
Query query=sesn.createQuery("from Employees") ;
List list = query.list();
Iterator itr = list.iterator();
while(itr.hasNext())
{
	user = (Employees)itr.next();
	
	String name = user.getName();
	
	System.out.println(name);
%>
  <tr>
  	<td><%=user.getId()%></td>
    <td> <%=user.getName()%> </td>
    <td> <%=user.getEmail()%> </td> 
    <td> <%=user.getSalary()%> </td>
  </tr>
  
<%
}
tx.commit();
sesn.close();
sf.close();
%>
</table>
</body>
</html>