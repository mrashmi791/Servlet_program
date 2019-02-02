package info.inetsolve.presentation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import info.inetsolve.DTO.RegistrationDetails;
import info.inetsolve.service.CrudOperation;

public class InsertData extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/**
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {

			// reading data from request.
			String studentName = request.getParameter("studentname");
			String email = request.getParameter("email");
			String dob = request.getParameter("dob");
			String password = request.getParameter("pwd");
			String confirmPassword = request.getParameter("cnfpwd");

			// comparing password
			if (!password.equals(confirmPassword)) {
				out.println("Password invalid..!!");
				return;
			}

			RegistrationDetails regDetails = new RegistrationDetails();

			regDetails.setStudentName(studentName);
			regDetails.setDob(dob);
			regDetails.setEmail(email);
			regDetails.setPassword(password);
			
			// Service call to save details.
			if (CrudOperation.saveData(regDetails)) {
				out.println("<br>Record has been inserted");

				// showing records
				CrudOperation.showRecords(response);
				
			} else {
				out.println("failed to insert the data");
			}
		} catch (Exception e) {
			out.println(e);
		}
		
	}

}
