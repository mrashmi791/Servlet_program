/**
 * 
 */
package info.school.DBConfig;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author lenovo
 *
 */
public class DBConnection {

	public static Connection getDBConnection(String dataBaseName) throws SQLException {
		Driver d = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/" + dataBaseName, "root","Ankit@123");

				
		return con;
	}

}
