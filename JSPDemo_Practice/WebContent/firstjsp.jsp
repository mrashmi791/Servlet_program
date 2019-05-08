
<%!

String str ;

%>

<%

str=request.getParameter("uname");

%>

<%="Welcome "+ str %>

<%=new java.util.Date() %>


<%! int add(int x , int y) {
     int z = x + y;
     return z;
     }
 %>
     
 <%="Result : " + add(22,44) %>    
 
 