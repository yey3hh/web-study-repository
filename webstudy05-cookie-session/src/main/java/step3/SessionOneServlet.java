package step3;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.MemberVO;

/**
 * Servlet implementation class SessionOneServlet
 */
@WebServlet("/SessionOneServlet")
public class SessionOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =  response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Session Study</title>");
		out.print("</head>");
		out.print("<body bgcolor=lime>");
		out.print("<h3>" + getServletConfig().getServletName() + "</h3>");
//		세션 생성
//		id, password 검증 통과
//		기존 세션이 없으면 새로 생성, 있으면 기존 세션을 반환
		HttpSession session = request.getSession();
		session.setAttribute("mvo", new MemberVO("javaking", null, "손흥민", "런던"));
		out.print(session.getId());
		out.print("<br><br><a href=index.html>home</a>");
		
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}


}
