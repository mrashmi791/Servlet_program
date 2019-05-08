package info.inetsolve.displaylist;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.school.DBConfig.DBConnection;


public class RetriveStudentDetails extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			response.setContentType("text/html");
			Connection con = DBConnection.getDBConnection("student_database");
			PreparedStatement pst = con.prepareStatement("select * from student_details");
			ResultSet rs = pst.executeQuery();
			PrintWriter out=response.getWriter();
			
			out.println("<html><body style='background-color: gray'><table border='1'><tr><td>ID</td><td>Student name</td><td>Address</td><td>Class</td><td>Roll</td><td>Marks</td></tr>");
			
			while(rs.next()) {
				out.println(
						"<tr><td>"
							+rs.getString(1)+
						"</td><td>"
							+rs.getString(2)+
						"</td><td>"
							+rs.getString(3)+
						"</td><td>"
							+rs.getString(4)+
						"</td><td>"
							+rs.getString(5)+
						"</td><td>"
							+rs.getString(6)+
						"</td></tr>");
				
			}
			out.println("</table></body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
}
