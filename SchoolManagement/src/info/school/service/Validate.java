/**
 * 
 */
package info.school.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author lenovo
 *
 */
public class Validate {

	
//	   method to connect with database and validate email and password for login
	public static boolean check(String email, String password) throws ClassNotFoundException, SQLException {
		boolean result = false;
		String originalPass = "";
		Class.forName("com.mysql.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/student_database", "root",
				"Ankit@123");

		PreparedStatement ps = con.prepareStatement("select * from registration where email=?");
		ps.setString(1, email);

		ResultSet rs = ps.executeQuery();
		
		
		if(rs.next()) {
			originalPass = rs.getString("password");
			result = password.equals(originalPass);
		}
		
		return result;
	}

	
}
