/**
 * 
 */
package info.inetsolve.presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.inetsolve.DTO.RegistrationDetails;
import info.school.service.SignUp;

/**
 * @author lenovo
 *
 */
public class TakeDataFromUser extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		
		// reading data from user.
					String studentName = request.getParameter("studentname");
					String email = request.getParameter("email");
					String dob = request.getParameter("dob");
					String password = request.getParameter("pwd");
					String confirmPassword = request.getParameter("cnfpwd");

					// comparing password
					if (!password.equals(confirmPassword)) {
						//out.println("Password invalid..!!");
						
						out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
						out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
						out.println("<script>");
						out.println("$(document).ready(function() {");
						out.println("swal ( 'Oops' ,  'Wrong id or password...!!!' ,  'error' );");
						out.println("});");
						out.println("</script>");
						return;
					}

					
//					create object of RegistrationDetails class
					
					RegistrationDetails regDetails = new RegistrationDetails();
					
//					set data
					
					regDetails.setDob(dob);
					regDetails.setStudentName(studentName);
					regDetails.setEmail(email);
					regDetails.setPassword(password);
					
					try {
						if(SignUp.InsertData(regDetails)) {
						//	out.println("<br>Register Successfully....!!!!!!");
							
						out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
						out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
						out.println("<script>");
						out.println("$(document).ready(function() {");
						out.println("swal ( 'Welcome' ,  'Successfull...!!!' ,  'success' );");
						
						out.println("});");
						
						out.println("</script>");
						
						response.sendRedirect("./signin.html");
							
						} else {
							//out.println("failed to register");
							
							
							out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
							out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
							out.println("<script>");
							out.println("$(document).ready(function() {");
							out.println("swal ( 'Oops' ,  'Wrong id or password...!!!' ,  'error' );");
							out.println("});");
							out.println("</script>");
								
							
							}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
		
	}
}
