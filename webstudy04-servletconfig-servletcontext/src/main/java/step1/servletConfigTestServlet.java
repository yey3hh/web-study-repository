package step1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * ServletConfig 사용법을 보여주는 예제
 * ServletConfig는 ServletContext를 개별 서블릿에서 사용할 수 있도록 그 주소값을 저장하고 있다.
 * 필요시 ServletConfig에 설정 정보를 저장하게 할 수도 있음
 * 사례) Spring의 DispatcherServlet의 init(ServletConfig)에 자신의 스프링 설정 파일 위치 정보를 전달할 수 있음 
 */
@WebServlet(urlPatterns = "/config-test", initParams = {@WebInitParam(name = "contextConfigLocation", value = "/WEB-INF/springmvc-config.xml")})
public class servletConfigTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		응답시 컨텐트 타입을 설정, 브라우저에서 지금 응답은 HTML 문서야 라고 메세지를 보내기 위함
		response.setContentType("text/html;charset=UTF-8");
//		HTML을 브라우저로 전송하기 위한 출력 스트림
		PrintWriter out =  response.getWriter();
		out.print("<html>");
		out.print("<head>");
		out.print("<title>ServletConfig study</title>");
		out.print("</head>");
		out.print("<body>");
//		web container에 의해 init(ServletConfig) 호출시에 주입 받았음
		ServletConfig config = this.getServletConfig();
//		ServletConfig가 사원(해당 Servlet)의 사원증이라고 하면
//		ServletContext는 그 사원이 속한 회사의 인트라넷이다 (공유 자원)
//		ServletConfig 사원증을 가진 자(Servlet)만이 사내 인트라넷인 ServletContext를 이용할 수 있다.
		ServletContext context = config.getServletContext();
		out.print("<h3>Hello ServletConfig : " + config + "</h3>");
		out.print("<h3>watsup ServletContext : " + context + "</h3>");
		String springConfig =  config.getInitParameter("contextConfigLocation");
		out.print("<strong>스프링 설정 파일 정보 : " + springConfig + "</strong><br />");
		
		String securityInfo = 
				this.getServletConfig().getServletContext().getInitParameter("securityConfigInfo");
				out.print("<h3>ServletContext의 securityInfo : " + securityInfo + "</h3>");
		
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

}
