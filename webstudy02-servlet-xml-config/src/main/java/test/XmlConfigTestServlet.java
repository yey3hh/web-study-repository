package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class XmlConfigTestServlet
 */
//@WebServlet("/XmlConfigTestServlet")
public class XmlConfigTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public XmlConfigTestServlet() {
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
		out.print("<title>web.xml config Servlet Study</title>");
		out.print("</head>");
		out.print("<body bgcolor=orange>");
		out.print("<h3>xml로 메타데이터가 설정된 Servlet입니다.</h3>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

}
