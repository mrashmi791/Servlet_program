
<!-- 

	To view all data of employee.
 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

<%@page import="info.inetsolve.CrudOperation,info.inetsolve.*,java.util.*"%>  

  
<h1>Users List</h1>  

<%  
List<User> list=CrudOperation.getAllRecords();  
request.setAttribute("list",list);  
%>  

<table border="1" width="90%">  
<tr><th>Id</th><th>Name</th><th>Address</th><th>Email</th>  
<th>Sex</th><th>Designation</th><th>Salary</th> <th>Edit</th><th>Delete</th></tr>  
<c:forEach items="${list}" var="u">  
<tr><td>${u.getId()}</td><td>${u.getName()}</td><td>${u.getAddress()}</td>  
<td>${u.getEmail()}</td><td>${u.getMobile()}</td><td>${u.getSex()}</td><td>${u.getDesignation()}</td> <td>${u.getSalary()}</td>
<td><a href="editform.jsp?id=${u.getId()}">Edit</a></td>  
<td><a href="deleteuser.jsp?id=${u.getId()}">Delete</a></td></tr>  
</c:forEach>  
</table>  
<br/><a href="adduserform.jsp">Add New User</a>  
  

</body>
</html>