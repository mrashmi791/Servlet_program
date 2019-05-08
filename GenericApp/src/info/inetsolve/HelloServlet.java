package info.inetsolve;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet {

	
	@Override
	public void service(ServletRequest req, ServletResponse rep) throws ServletException, IOException {
		
		
		PrintWriter out = rep.getWriter();
		rep.setContentType("text/html");
		
		out.println("<html> <body> <center> <h1>");
		
		out.println("Hello");
		out.println("I am servlet");
		
		out.println(" </h1> </center>  </body> </html> ");
		
				
	}
	

}
