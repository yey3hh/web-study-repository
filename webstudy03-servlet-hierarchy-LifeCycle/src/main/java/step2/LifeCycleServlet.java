package step2;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     * WAS(Web Container)가 생성자를 호출하여 객체를 생성 - 한번 호출
     */
    public LifeCycleServlet() {
        super();
        System.out.println(getClass() + " 객체 생성");
    }
    
    /**
     *  @see Servlet#init(ServletConfig)
     *  WAS(Web Container)가 객체 생성 후 단 한번 호출
     *  초기화 작업, 예) 설정 정보 입력, 데이터베이스 연결, 파일 로딩
     */
    public void init() throws ServletException {
    	System.out.println(getClass() + " init()");
    }

	/**
	 * @see Servlet#destroy()
	 * WAS(Web Container)가 단 한번 호출, 서블릿 언로드, 서블릿 컨테이너 종료
	 * 직전에 호출, 예) 데이터 베이스 연결 해제, 캐시 정리, 파일 닫기 등
	 */
	public void destroy() {
		System.out.println(getClass() + " destroy()");
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 * WAS(Web Container)가 호출. 클라이언트가 요청할 때마다 매번 실행
	 * 예) 다양한 웹 서비스(로그인, 회원가입, 상품 검색 등)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println(getClass() + " service()");
	}

}
