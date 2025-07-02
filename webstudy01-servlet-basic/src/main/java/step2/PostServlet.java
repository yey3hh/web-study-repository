package step2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		응답시 컨텐트 타입을 설정, 브라우저에서 지금 응답은 HTML 문서야 라고 메세지를 보내기 위함
		response.setContentType("text/html;charset=UTF-8");
//		HTML을 브라우저로 전송하기 위한 출력 스트림
		PrintWriter out =  response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Servlet Study</title>");
		out.print("</head>");
		out.print("<body color=lime>");
		out.print("<h3>Servlet post 방식 연동</h3>");
		String nick = request.getParameter("nick");
//		만약 post 방식이 한글 처리가 안되면 아래와 같이 명시해야한다.
//		request.setCharacterEncoding("UTF-8");
		out.print("별명 : " + nick);
		String email = request.getParameter("email");
		out.print("<br />이메일 : " + email);
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

}
