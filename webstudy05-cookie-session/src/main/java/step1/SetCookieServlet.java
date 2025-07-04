package step1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookieServlet
 */
@WebServlet("/SetCookieServlet")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		응답시 컨텐트 타입을 설정, 브라우저에서 지금 응답은 HTML 문서야 라고 메세지를 보내기 위함
		response.setContentType("text/html;charset=UTF-8");
//		HTML을 브라우저로 전송하기 위한 출력 스트림
		PrintWriter out =  response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Set Cookie Study</title>");
		out.print("</head>");
		out.print("<body bgcolor=yellow>");
		out.print("<h3>Set Cookie Servlet</h3>");
		String time = new Date().toString().replace(" ", "-");
		Cookie cookie = new Cookie("timeCookie", time);
		cookie.setMaxAge(60);	// ~초 동안 유지
		response.addCookie(cookie);	// 응답시 쿠키가 전송되도록 한다.
		
		out.print("cookie를 생성해 클라이언트에 전송<br><br>");
		out.print("<br><br><a href=index.html>home 으로 <br><br>");
		
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

}
