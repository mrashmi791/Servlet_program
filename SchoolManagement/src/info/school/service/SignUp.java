package info.school.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

import info.inetsolve.DTO.RegistrationDetails;
import info.school.DBConfig.DBConnection;

public class SignUp extends HttpServlet {

	
	/**
	 * Method to  insert registration data in database
	 */
	private static final long serialVersionUID = 1L;

	public static boolean InsertData(RegistrationDetails details) throws SQLException {
		
		Connection con = DBConnection.getDBConnection("student_database");
		
		
//		insert value in database
		
		PreparedStatement pst = con.prepareStatement("insert into registration values(?,?,?,?)");
		
		pst.setString(1, details.getStudentName());
		pst.setString(2,details.getEmail());
		pst.setString(3, details.getDob());
		pst.setString(4, details.getPassword());
		
		int count = pst.executeUpdate();
		
		return count > 0 ;
	}
}
