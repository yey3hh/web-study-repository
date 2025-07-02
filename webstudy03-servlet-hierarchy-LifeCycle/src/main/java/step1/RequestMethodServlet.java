package step1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestMethodServlet
 */
@WebServlet("/RequestMethodServlet")
public class RequestMethodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestMethodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 아래처럼 우리가 직접 service를 오버라이딩하면 톰캣(웹 컨테이너)이 호출하는 것을 확인할 수 있음
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(request.getRequestURI() + " service method 실행");
//	}
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		응답시 컨텐트 타입을 설정, 브라우저에서 지금 응답은 HTML 문서야 라고 메세지를 보내기 위함
		response.setContentType("text/html;charset=UTF-8");
//		HTML을 브라우저로 전송하기 위한 출력 스트림
		PrintWriter out =  response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Servlet Method Study</title>");
		out.print("</head>");
		out.print("<body bgcolor=yellow>");
		String method = request.getMethod();
		out.print("<h3>" + method + "방식 요청에 대한 응답</h3>");
		// 클라이언트가 보낸 정보를 반환받는다.
		String info = request.getParameter("searchKeyword");
		out.print("<strong>검색어는 " + info + "입니다.</strong>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out =  response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Servlet Method Study</title>");
		out.print("</head>");
		out.print("<body bgcolor=yellow>");
		String method = request.getMethod();
		out.print("<h3>" + method + "방식 요청에 대한 응답</h3>");
		// 클라이언트가 보낸 정보를 반환받는다.
		String foodName = request.getParameter("foodName");
		String tasteType = request.getParameter("tasteType");
		out.print("<strong>음식 명 :  " + foodName + "</strong><br />");
		out.print("<strong>맛 타입 :  " + tasteType + "</strong>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
    }
}
