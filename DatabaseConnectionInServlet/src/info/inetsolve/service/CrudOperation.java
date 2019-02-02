/**
 * 
 */
package info.inetsolve.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

import info.inetsolve.DBConfig.DataBaseConfiguration;
import info.inetsolve.DTO.RegistrationDetails;

/**
 * @author lenovo
 *
 */
public class CrudOperation {
	
	public static boolean saveData(RegistrationDetails details) throws SQLException {

		Connection con = DataBaseConfiguration.getDBConnection("student_database");

		PreparedStatement pst = con.prepareStatement("insert into registration values(?,?,?,?)");

		pst.setString(1, details.getStudentName());
		pst.setString(2, details.getEmail());
		pst.setString(3, details.getDob());
		pst.setString(4, details.getPassword());

		int i = pst.executeUpdate();

		return i > 0;

	}
	
	
	
	public static void showRecords(HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {

		    
			con = DataBaseConfiguration.getDBConnection("student_database");
			st = con.createStatement();
			
			String query = "select * from registration";
			rs = st.executeQuery(query);

			boolean temp = rs.next();
			if (temp) {
				while (temp) {
					
				
				
					out.println("<br/><b>student name:</b> " + rs.getString("student_name") + "<br/><b>email:</b> "
							+ rs.getString("email") + "<br/><b>dob:</b> " + rs.getString("dob") + "</br/><b>password:</b> "
							+ rs.getString("password") );
					
					temp = rs.next();
				}

			} else {
				System.out.println("No record available in database..!!");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
	}
	
	


}
