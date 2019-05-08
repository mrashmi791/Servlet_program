
 <!--  Here we will add details and call save method of CrudOperation class

 -->
 
 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

<%@page import="info.inetsolve.CrudOperation,info.inetsolve.*"%>  
<jsp:useBean id="u" class="info.inetsolve.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
  
<%  
int i=CrudOperation.save(u);  
if(i>0){  
response.sendRedirect("adduser-success.jsp");  
}else{  
response.sendRedirect("adduser-error.jsp");  
}  
%>  


</body>
</html>