<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style>

	body {
		margin: 100px;
	}
	
</style>
	
</head>
<body>
<%@ include file= "header.jsp" %>
<form action="valid" method="GET">
Enter Username<input type="text" name = "uname"/><br/>
Enter Password<input type="text" name = "pwd"/><br/>

<input type="submit" value = "Login"/>
</form>
</body>
</html>