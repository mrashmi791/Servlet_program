/**
 * 
 */
package info.inetsolve.ServletContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

/**
 * @author lenovo
 *
 */
public class FirstServlet extends HttpServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws IOException {
		
		ServletContext context  = getServletContext();
		
		String id = context.getInitParameter("id");
		String name = context.getInitParameter("name");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("id : " + id + "<br/>");
		out.println("name : " + name + "<br/>");
		
		context.setAttribute("address", "patna");
		context.setAttribute("mob", "9826354872");
		
		System.out.println("This values are stored in ServletContext");
		
	}


}
