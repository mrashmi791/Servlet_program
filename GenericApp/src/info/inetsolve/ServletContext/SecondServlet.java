/**
 * 
 */
package info.inetsolve.ServletContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

/**
 * @author lenovo
 *
 */
public class SecondServlet extends HttpServlet {
	
	public void service(ServletRequest request, ServletResponse response) throws IOException {
		
		ServletConfig config = getServletConfig();
		ServletContext context = config.getServletContext();
		
		String id = context.getInitParameter("id");
		String name = context.getInitParameter("name");
		String address = (String) context.getAttribute("Address");
		String mob = (String) context.getAttribute("mob");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("id : "+id+"<br/>");
		out.println("name : "+name+"<br/>");
		out.println("Address : "+address+"<br/>");
		out.println("mob : "+mob+"<br/>");
		
		
	}

}
