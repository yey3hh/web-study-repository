package step3;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletContextTestServlet
 */
@WebServlet("/context-test2")
public class ServletContextTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =  response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>ServletContext study2</title>");
		out.print("</head>");
		out.print("<body bgcolor=orange>");
		out.print("<h3>Hello ServletContextTestServlet2</h3>");
		String securityInfo = 
		this.getServletConfig().getServletContext().getInitParameter("securityConfigInfo");
		out.print("<h3>ServletContext의 securityInfo : " + securityInfo + "</h3>");
		
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

}
