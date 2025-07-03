package step3;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleCountServlet
 */
@WebServlet("/life-count")
public class LifeCycleCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleCountServlet() {
        super();
        System.out.println(getClass() + "객체 생성");
    }
    private int count;	// 0으로 초기화
    @Override
    public void init() throws ServletException {
    	// 매개 변수 없는 것을 권장
        System.out.println(getClass() + "init() count : " + count++);

    }
    
	@Override
	public void destroy() {
		System.out.println(getClass() + "destroy()");

	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		응답시 컨텐트 타입을 설정, 브라우저에서 지금 응답은 HTML 문서야 라고 메세지를 보내기 위함
		response.setContentType("text/html;charset=UTF-8");
//		HTML을 브라우저로 전송하기 위한 출력 스트림
		PrintWriter out =  response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Servlet LifeCycle</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h3>접속 수 : " + count + "</h3>");
		count++;
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

}
