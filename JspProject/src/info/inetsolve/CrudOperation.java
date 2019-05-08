package info.inetsolve;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import info.inetsolve.db.config.DatabaseConnection;
import info.inetsolve.User;


/*
 * 
 * It contain all queries to insert update delete and retrive the records.
 * 
 * 
 */


public class CrudOperation {

	public static int save(User u) throws SQLException {
		int status = 0;

		Connection con = DatabaseConnection.getDBConnection("employee_database");

		PreparedStatement ps = con
				.prepareStatement("insert into employee_info(id,name,password,email,sex,designation,salary) values(?,?,?,?,?,?,?)");
		ps.setInt(1, u.getId());
		ps.setString(2, u.getName());
		ps.setString(3, u.getAddress());
		ps.setString(4, u.getEmail());
		ps.setString(5, u.getSex());
		ps.setString(6, u.getDesignation());
		ps.setDouble(7, u.getSalary());
		status = ps.executeUpdate();
		
		return status;
	}

	
	public static int update(User u) throws SQLException {
		int status = 0;

		Connection con = DatabaseConnection.getDBConnection("employee_database");
		
		 PreparedStatement ps=con.prepareStatement(  
				 "update employee_info set  name=?,password=?,email=?,sex=?,designation=? , salary=? where id=?");  
		 
		 ps.setInt(1, u.getId());
			ps.setString(2, u.getName());
			ps.setString(3, u.getAddress());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getSex());
			ps.setString(6, u.getDesignation());
			ps.setDouble(7, u.getSalary());
			status = ps.executeUpdate();
		return status;

	}
	
	public static int delete(User u) throws SQLException {
		int status = 0;

		Connection con = DatabaseConnection.getDBConnection("employee_database");
		
		 PreparedStatement ps=con.prepareStatement("delete from employee_info where id=?");  
		 
		  ps.setInt(1,u.getId());  
	        status=ps.executeUpdate();  
		return status;

	}
	
	public static List<User> getAllRecords() throws SQLException {
		List<User> list=new ArrayList<User>();
		Connection con = DatabaseConnection.getDBConnection("employee_database");
		
		 PreparedStatement ps=con.prepareStatement("select * from employee_info");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()) {
	        	 User u=new User();  
	        	 
	        	 ps.setInt(1, u.getId());
	 			ps.setString(2, u.getName());
	 			ps.setString(3, u.getAddress());
	 			ps.setString(4, u.getEmail());
	 			ps.setString(5, u.getSex());
	 			ps.setString(6, u.getDesignation());
	 			ps.setDouble(7, u.getSalary());
	 			 list.add(u);  
	        }
		return list;  
		
	}
	
	public static User getRecordById(int id) throws SQLException{  
	    User u=null;
	    Connection con = DatabaseConnection.getDBConnection("employee_database");
	    PreparedStatement ps=con.prepareStatement("select * from employee_info where id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new User(); 
            ps.setInt(1, u.getId());
 			ps.setString(2, u.getName());
 			ps.setString(3, u.getAddress());
 			ps.setString(4, u.getEmail());
 			ps.setString(5, u.getSex());
 			ps.setString(6, u.getDesignation());
 			ps.setDouble(7, u.getSalary()); 
        }
		return u;  
	    
	}
}
