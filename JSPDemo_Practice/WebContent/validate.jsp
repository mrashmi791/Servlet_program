<%@page import="java.sql.Connection, java.sql.Driver,java.sql.DriverManager,java.sql.ResultSet,java.sql.SQLException,java.sql.Statement" errorPage="myerror.jsp"%>
<%!Connection con;

	public void jspInit() {
		try {
			Driver d = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
			System.out.println("driver is registered");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/student_database", "root", "Ankit@123");
			System.out.println("Successfully connected");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not connected");

		}
	}

	public void jspDestroy() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}%>
<%

	String user = request.getParameter("uname");
	String pass = request.getParameter("pwd");
	System.out.println("uname: "+ user + "pwd : "+ pass);
	Statement st = con.createStatement();
	
	ResultSet rs = st.executeQuery(
			"select * from registration where student_name ='" + user + "' and password='" + pass + "'");
	if (rs.next()) {
		System.out.println("valid user");
		session.setAttribute("sname", user);
		response.sendRedirect("home.jsp");

	} else {
		System.out.println("not valid user");
		//application.getRequestDispatcher("/login.jsp").forward(request, response);
		response.sendRedirect("login.jsp");
	}
%>
