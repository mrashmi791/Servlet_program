/**
 * 
 */
package info.inetsolve.presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.school.service.Validate;

/**
 * @author lenovo
 *
 */
public class LoginDetails extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

//		read data from user
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pwd");

		try {
//			   compare data from database
			if (Validate.check(email, pass)) {

				//out.println("Login successfuly...!!");
				
				out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
				out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
				out.println("<script>");
				out.println("$(document).ready(function() {");
				out.println("swal( 'Welcome' ,  'Successfull...!!!' ,  'success' ).then((value) => {\r\n" + 
						" swal(`The returned value is: ${value}`);\r\n" + 
						"});;");
				out.println("});");
				out.println("</script>");
				
				
					
//				response.sendRedirect("welcome");
//				return;

			} else {

				//out.println("Username or Password incorrect");
				
				out.println("<script src=\"https://unpkg.com/sweetalert/dist/sweetalert.min.js\"></script>");
				out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
				out.println("<script>");
				out.println("$(document).ready(function() {");
				out.println("swal ( 'Oops' ,  'Wrong id or password...!!!' ,  'error' );");
				out.println("});");
				out.println("</script>");
				
				
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

}
