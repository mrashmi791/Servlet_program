
<!-- 

To delete any record.

 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    
    <%@page import="info.inetsolve.CrudOperation"%>  
<jsp:useBean id="u" class="info.inetsolve.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
<%  
CrudOperation.delete(u);  
response.sendRedirect("viewusers.jsp");  
%>  