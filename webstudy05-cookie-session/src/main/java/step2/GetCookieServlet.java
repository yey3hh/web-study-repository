package step2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

/**
 * Servlet implementation class GetCookieServlet
 */
@WebServlet("/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out =  response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Get Cookie Study</title>");
		out.print("</head>");
		out.print("<body bgcolor=orange>");
		out.print("<h3>Get Cookie Servlet</h3>");
//		client가 전송한 request로부터 쿠키 정보를 반환받는다.
		Cookie coockies[] = request.getCookies();
		if (coockies==null) {
			out.print("쿠키가 존재하지 않습니다.");
		} else {
			String timeInfo = null;
			for (int i = 0; i < coockies.length; i++) {
				if (coockies[i].getName().equals("timeCookie")) {
					timeInfo = coockies[i].getValue();
					break;
				}
			}
			if (timeInfo != null) {
				out.print("time 쿠키 정보 : " + timeInfo);
			} else {
				out.print("<br>time 쿠키 정보가 존재하지 않습니다.");
			}
		}
		
		out.print("<br><strong>클라이언트로부터 time 쿠키 정보를 확인</strong>");
		out.print("<br><br><a href=index.html>home 으로 <br><br>");
		
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

}
