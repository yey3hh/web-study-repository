package step5;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionOneServlet
 */
@WebServlet("/SessionThreeServlet")
public class SessionThreeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =  response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Session Study</title>");
		out.print("</head>");
		out.print("<body bgcolor=orange>");
		out.print("<h3>" + getServletConfig().getServletName() + "</h3>");
//		getSession(false); : 기존 세션이 있으면 기존 세션 반환, 없으면 null 반환
		HttpSession session =  request.getSession(false);
		
		if (session == null) {
			out.print("세션이 존재하지 않습니다.");
		} else {
			session.invalidate();
			out.print("session 무효화 시킴 invalidate() 실행");
		}
		
		out.print("<br><br><a href=index.html>home</a>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}


}
